package day18.student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileNameExtensionFilter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

private static String fileName = "src/day18/student/list.txt";


public class ServerMain {
	private list student
	public static void main(String[] args) {
		int port = 5001;
		load();
		System.out.println("list");
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				Thread t = new ServerThread(serverSocket.accept());
				t.start();
				save();	
			}
		} catch (IOException e) {
			System.out.println("[예외가 발생하여 서버를 종료합니다.]");
		}
		save();
		
	}
	private static void save() {
		String fileName = "src/day18/student/list.txt";
		
		try {
			ObjectOutputStream foos = 
					new ObjectOutputStream(new FileOutputStream(fileName));
			foos.writeObject(list);
			foos.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}

	private static void load() {
		
	
}
	
@RequiredArgsConstructor
class ServerThread extends Thread{
	@NonNull
	private Socket socket;
	
	List<Student> list;//
	
	private ObjectInputStream ois;//클라이언트에서 읽어오때 사용
	private ObjectOutputStream oos;//클라이언트에 보낼 때 사용
	
	public void run() {
		try {
			//클라이언트가 요청한 기능을 실행
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			//클라이언트가 요청한 기능을 입력
			String menu = ois.readUTF();
			//요청한 기능을 실행 
			switch(menu) {
			case "LOAD":
				load();
				break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
		
		try {	
				oos.writeObject(List);
				oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}