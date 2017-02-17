import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;



public class SrvBeg {

	private final static int port =  9876;
	public static int n;
	public static String tab [];

	public static void main(String argv[]) throws IOException 
	{

		String clientSentence;
		ServerSocket serveurSocket = new ServerSocket(port);
		Socket coSocket = null;

		try {
			while(true)
			{
				coSocket = serveurSocket.accept();
				InetAddress adress_sock = coSocket.getInetAddress();
				int port_sock = coSocket.getPort();
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(coSocket.getInputStream()));
				DataOutputStream outToClient = new DataOutputStream(coSocket.getOutputStream());

				while((clientSentence = inFromClient.readLine()) != null){
					if(clientSentence.contains(":")){						
						System.out.println(adress_sock+"/"+port_sock+"");
						System.out.println("Beg : "+getNbBeg(clientSentence)+" ");
						System.out.println("Phrase : "+getPhrase(clientSentence)+" ");						

						outToClient.writeBytes(begaiement(clientSentence)+"\n");
					}else{
						System.out.println(adress_sock+"/"+port_sock+"");
						System.out.println("Erreur BEG");
						System.out.println("Phrase : "+clientSentence+" \n");
						
						outToClient.writeBytes("1Erreur nombre\n");
					}
				}
				outToClient.flush();
			}

		} catch (SocketException s) {
			s.printStackTrace();
		} finally {
			coSocket.close();
			serveurSocket.close();
		}

	}

	private static String begaiement(String clientSentence) {
		int nb;
		String[] words;
		
		try{
			nb = Integer.parseInt(getNbBeg(clientSentence));
			if (nb == 0) return "0";
			clientSentence = getPhrase(clientSentence);
			words = clientSentence.split(" ");
		} catch (Exception e) {
			return "1Erreur nombre \n";
		}

		String s = "";
		for(int i = 0; i < words.length; i++) {
			for (int j = 0; j < nb; j++) {
				s += words[i] + " ";
			}
		}
		return s;
	}

	private static String getNbBeg(String clientSentence){
		String[] word;
		word = clientSentence.split(":");
		return word[0];
	}

	private static String getPhrase(String clientSentence){
		String[] word;
		word = clientSentence.split(":");
		return word[1];
	}
}