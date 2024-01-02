package day15;

import java.util.Scanner;

import javax.print.attribute.standard.PrinterMessageFromOperator;

public class HomeworkEx1 {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 영어 단어장을 관리하는 프로그램을 작성하세요.
		 * 기한은 1/5까지 github에 업로드 후 강사에게 공유(단톡방)
		 * 
		 * -한 단어에 뜻이 여러개 있을 수 있음.
		 * -단어, 품사, 뜻을 관리
		 * -단어 추가
		 * -단어 수정
		 * -단어 삭제
		 * -뜻 추가
		 * -뜻 수정
		 * -뜻 삭제
		 * -단어 조회
		 * 
		 * -기타 추가 기능을 구현해도 됨
		 * -등록된 단어장에서 랜덤으로 문제가 나오고 맞추는 기능
		 * - 오답 노트를 관리해주는 기능
		 * -많이 조회한 단어를 확인하는 기능
		 * */
		
		int menu;
		
		do {//메뉴 출력
			printmenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택 메뉴에 맞는 기능 실행
			runMenu(menu);
			
			}while(menu != 5);
	
		//프로그램 종료 안내 문구
		System.out.println("프로그램 종료!");

		
		
	}

	private static void runMenu(int menu) {
		// TODO Auto-generated method stub
		
	}

	private static void printmenu() {
		// TODO Auto-generated method stub
		
	}

}
