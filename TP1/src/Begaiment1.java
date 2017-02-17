import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Begaiment1 {
	
	private DatagramSocket dgSocket;
	private DatagramPacket dgPacket;
	private BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	private int nb;
	
	
	Begaiment1() throws SocketException{
		dgSocket = new DatagramSocket();
	}
	
	void go() throws IOException {
	
		dgPacket = new DatagramPacket(new byte[0],0);
		
		while(true){
			dgSocket.receive(dgPacket);
			String ligne = new String(dgPacket.getData(), dgPacket.getOffset(), dgPacket.getLength(),StandardCharsets.UTF_8);			
			System.out.println("Datagram received from: "+dgPacket.getSocketAddress());		// on recupere l'adresse du packet
			System.out.println("Data : "+ ligne);
			
			try{
				nb = Integer.parseInt(ligne.substring(0,2));
			}catch(Exception e){
				
			}
		}
	}
}
