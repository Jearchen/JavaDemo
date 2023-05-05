import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.net.ServerSocket;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.nio.channels.SelectionKey;
import java.util.Iterator;
import java.util.Set;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;

interface Server{

    public void start();
 
    public void run();

    public void close();

}

class ServerImpl implements Server{
    private Selector selector;
    private ServerSocketChannel channel;
    private ByteBuffer buffer = ByteBuffer.allocate(10240);

    @Override
    public void start() {
        try{
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(InetAddress.getByName("localhost"),9819));
            server.configureBlocking(false);
            selector = Selector.open();
            server.register(selector,SelectionKey.OP_ACCEPT);
        }catch(ClosedChannelException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    

    @Override
    public void run(){
        try{
            while(selector.select()>0){
                Set<SelectionKey> keyList = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keyList.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                        if(key.isAcceptable()){
                            ServerSocketChannel channel =(ServerSocketChannel) key.channel();
                            SocketChannel client = channel.accept();
                            client.configureBlocking(false);
                            client.register(selector,SelectionKey.OP_READ|SelectionKey.OP_WRITE,buffer.duplicate());
                        }

                        if(key.isReadable()){
                            SocketChannel channel = (SocketChannel) key.channel();
                            buffer.clear();
                            channel.read(buffer);
                            buffer.flip();
                            System.out.println(new String(buffer.array()));
                            key.interestOps(SelectionKey.OP_WRITE);
                        }

                        if(key.isWritable()){
                            SocketChannel channel = (SocketChannel) key.channel();
                            ByteBuffer writeBuffer = (ByteBuffer) key.attachment();
                            writeBuffer.rewind();
                            channel.write(writeBuffer);
                            key.interestOps(SelectionKey.OP_READ);
                        }
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void close(){
        System.out.println("关闭服务器。。。。");
        try{
            channel.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
    }
}

public class RunServer{
    public static void main(String[]args){
        ServerImpl server = new ServerImpl();
        try{
            System.out.println("启动服务器。。。。");
            server.start();
            server.run();
        }catch(Exception e){
            System.out.println("服务器启动异常");
            System.out.println(e.getMessage());
        }
    }
}
