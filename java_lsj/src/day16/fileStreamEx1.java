package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileStreamEx1 {

	public static void main(String[] args) {
		try {
			FileInputStream fis12 = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//try resource를 이용한 예제로
		//파일을 열고나서 따로 닫지 않아도 try문이 종료되면 자동으로 닫아짐
		String fileName = "src/day16/fileEx3.txt";
		try(FileInputStream fis1 = new FileInputStream(fileName);
			FileOutputStream fos1 = new FileOutputStream(fileName)){
			
			
			String str = "안녕하세요";
			for(int i=0;i < str.length(); i++) {
				fos1.write(str.charAt(i));
			}
			for(int i =0; i<str.length();i++) {
				int ch = fis1.read();
				System.out.print((char)ch);
			}
		
		}catch(FileNotFoundException e) {
			System.out.println(fileName+ "파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			System.out.println("파일 작업 중 예외 발생.");
		}
}
}


