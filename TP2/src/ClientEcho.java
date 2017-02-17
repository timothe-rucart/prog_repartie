import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientEcho {

	ClientEcho() throws UnknownHostException, IOException{
		String hostname = "localhost";

		Socket theSocket = new Socket(hostname, 7);
		BufferedReader networkIn = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(theSocket.getOutputStream());
		System.out.println("Connected to echo server");

		while (true) {
			String theLine = userIn.readLine();
			if (theLine.equals(".") || theLine.equals("fin") || theLine.equals("FIN"))
				break;
			out.println(theLine);
			out.flush();
			System.out.println(networkIn.readLine());
		}
		networkIn.close();
		out.close();
	}
	
	public static void main(String [] args) throws UnknownHostException, IOException{
		ClientEcho c1  = new ClientEcho();
	}
}
