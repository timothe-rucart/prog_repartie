import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class ClientUDP {

	private DatagramSocket dgSocket;
	BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	String ligne;
	int longueur;
	
	public ClientUDP() throws SocketException {
		dgSocket = new DatagramSocket();		
	}
	
	void go(String h, String port) throws IOException {
		DatagramPacket dgPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(h), Integer.parseInt(port));
		String s;

		while (true) {
			dgSocket.send(dgPacket);
			System.out.println("Datagram received from " + dgPacket.getSocketAddress());

			dgPacket.setSocketAddress(dgPacket.getSocketAddress());
			s = new java.util.Date().toString() + "\n";
			byte[] bufDate = s.getBytes();
			dgPacket.setData(bufDate, 0, bufDate.length);

			dgSocket.receive(dgPacket);
		}
	
	}
	
	public static void main(String args[]) throws SocketException, IOException{
		System.out.println("Client UDP");
		new ClientUDP().go(args[0], args[1]);
	}
}
