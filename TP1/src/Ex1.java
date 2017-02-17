import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class Ex1 {
	
	public static void main(String args[]) throws SocketException{
	
		Enumeration<NetworkInterface> 	list = NetworkInterface.getNetworkInterfaces();
		for(NetworkInterface var : Collections.list(list)){
			displayInterfaceInformation(var);
			
		}
		
	}
	
	   static void displayInterfaceInformation(NetworkInterface var) throws SocketException {
	        System.out.printf("Display name: %s\n", var.getDisplayName());
	        System.out.println("taille :"+var.getMTU());
	        System.out.printf("Name: %s\n", var.getName());
	        Enumeration<InetAddress> inetAddresses = var.getInetAddresses();
	        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
	        	System.out.printf("InetAddress: %s\n", inetAddress);
	        }
	        System.out.printf("\n");
	     }
}
