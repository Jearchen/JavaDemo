
import java.util.Scanner;
import java.net.Socket;
import java.io.OutputStream;
import java.util.Scanner;
import java.lang.Exception;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
public class TCPClient{
	private static Socket client = null;
	private static OutputStream outStream = null; 
	public static void tryConnect(InetAddress address ) throws IOException{
		InetSocketAddress sockAddress = new InetSocketAddress(address,53221);
		client.connect(sockAddress);
	}

	public static void sendMessage(String s) throws IOException{
		BufferedWriter BR = new BufferedWriter(new OutputStreamWriter(outStream));
		BR.write(s,0,s.length());
		BR.newLine();
		BR.flush();		
	}

	public static void quit() throws IOException{
		outStream.write("quit".getBytes());
	}

	public static void main(String[] args){
		try{
			client =  new Socket();
			InetAddress serverInfo = InetAddress.getByName("localhost");
			//client.bind(new InetSocketAddress(serverInfo,53221));
			tryConnect(serverInfo);
			outStream = client.getOutputStream();
			Scanner in = new Scanner(System.in);
			String data = in.next();
			while(!data.equals("q")){
				sendMessage(data);
				data = in.next();
			}
			quit();
			outStream.close();
		}catch (IOException e){
			System.out.println(e.getMessage());
		}	
	}
}
