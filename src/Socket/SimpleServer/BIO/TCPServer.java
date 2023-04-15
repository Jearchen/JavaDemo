import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
public class TCPServer{
	public static void transFormSocket(ServerSocket sServer) throws IOException{
		while(true){
			Socket cSocket = sServer.accept();
			BufferedReader BR = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			String command = BR.readLine();
			while(!command.equals("quit")){
				System.out.println(command);
				command = BR.readLine();
			}
			cSocket.close();
		}
	}
	
	public static void main(String[] args){
		try{
			System.out.println("start Server!");
			ServerSocket sServer = new ServerSocket(53221,10,InetAddress.getByName("127.0.0.1"));
			transFormSocket(sServer);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
