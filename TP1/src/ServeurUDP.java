import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class ServeurUDP {
	private DatagramSocket dgSocket;

	ServeurUDP(int pSrv) throws IOException {
		dgSocket = new DatagramSocket(pSrv);
	}

	void go() throws IOException {
		DatagramPacket dgPacket = new DatagramPacket(new byte[0], 0);
		String str;

		while (true) {
			dgSocket.receive(dgPacket);
			String str2 = new String(dgPacket.getData(), dgPacket.getOffset(),dgPacket.getLength(),StandardCharsets.UTF_8);
			System.out.println("Datagram received from " + dgPacket.getSocketAddress());
			System.out.println("donnes :"+str2);
			dgPacket.setSocketAddress(dgPacket.getSocketAddress());
			str = new java.util.Date().toString() + "\n";
			byte[] bufDate = str.getBytes();
			dgPacket.setData(bufDate, 0, bufDate.length);

			dgSocket.send(dgPacket);
		}
	}

	public static void main(String[] args) throws IOException {
		final int DEFAULT_PORT = 9876;
		new ServeurUDP( args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]) ).go();
	}
}
