package test;

import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		int port = 3000;
		String serverIP;
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			
			Socket socket = new Socket(serverIP, port);
	
		}	
	
	}

}
