import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientBeg {
	public static void main(String[] args){
		try{
			int port = 9876;
			Socket _socket = new Socket((String)null,port);
			InputStream isStream = _socket.getInputStream();
			PrintWriter writer = new PrintWriter(_socket.getOutputStream(), true);
			BufferedReader inServer = new BufferedReader(new InputStreamReader(isStream));
			BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));
			boolean continu = true;

			while(continu){

				System.out.println("Veuillez entrer une phrase : ");
				String phrase = inUser.readLine();

				if(!phrase.equals(".") && !phrase.toUpperCase().equals("FIN")){
					System.out.println("Niveau de begaiement : ");
					String nbBeg = inUser.readLine();
					writer.println(nbBeg+":"+phrase);

					System.out.println(inServer.readLine());
				}else{
					System.out.println("Ok Bye.");
					continu = false;
				}

			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}