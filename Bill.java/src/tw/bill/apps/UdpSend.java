package tw.bill.apps;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend {

	public static void main(String[] args) {
		String mesg ="hello,world";
		byte[] send=mesg.getBytes();
		try {
			
			DatagramSocket socket=new DatagramSocket();
			DatagramPacket packet=new DatagramPacket(send,send.length,InetAddress.getByName("192.168.50.50"),8888);
			socket.send(packet);
			
			socket.close();
			System.out.println("ok");
		}catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
