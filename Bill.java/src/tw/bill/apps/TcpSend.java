package tw.bill.apps;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.CORBA.portable.OutputStream;

public class TcpSend {

	public static void main(String[] args) {
		try {
		Socket socket=new Socket(InetAddress.getByName(""),7777);
		java.io.OutputStream out=socket.getOutputStream();
		out.write("hello,world\nHello,ok".getBytes());
		
		out.flush();
		out.close();
		socket.close();
		System.out.println("ok");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
