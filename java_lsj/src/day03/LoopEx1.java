package day03;

import java.util.Scanner;

public class LoopEx1 {

	public static void main(String[] args) {
		// 문자를 입력받아 입력받은 문자를 출력하고, Q를 입력하면 종료하는 예제
		// 증감식 필요없음 증감식은 반복될 때만 사용
		
		Scanner scan = new Scanner(System.in);
		char ch = 'a';
		
		for( ; ch != 'q'; ) {
			System.out.println("입력 : " + ch);
		}
			ch = scan.next().charAt(0);
			System.out.println("문자 : " + ch);
	}
		
		
		
}
