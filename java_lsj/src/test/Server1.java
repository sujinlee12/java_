package test;

import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public static void main(String[] args) {
		
		int port =3000;
		
		ServerSocket server;
		
		try {
			server = new ServerSocket(port);
			
			
				Socket client = server.accept();
			
		}

	}

}
