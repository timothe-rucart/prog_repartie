import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Srv_Daytime {
	public static void main(String args[]){
		
		int port=9876;
		ServerSocket srvSocket;
		Socket socket;
		
		try{
			srvSocket = new ServerSocket(port);
			
			while(true){
				socket = srvSocket.accept();
				PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
				Date now = new Date();
				out.println(now.toString()+"\n");
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
