package day13;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringEx2 {
	
	static Scanner scan = new Scanner(System.in);
	static String [] list = new String [30];
	static int count = 0;
	public static void main(String[] args) {
		/* 문장들을 입력받아 배열에 저장하고, 특정 단어가 들어가 있는 문장들을
		 * 출력하는 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 문장 추가
		 * 2. 검색
		 * 3. 종료
		 **/

		/* 안녕하세요.
		 * 테스트
		 * 만나서 반갑습니다.
		 * 나는 홍길동입니다.
		 * 
		 * 나로 검색
		 * 
		 * 만나서 반갑습니다.
		 * 나는 홍길동입니다.
		 **/
		int menu;
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//기능 실행
			runMenu(menu);
		}while(menu !=3);
	}
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertString();
			break;
		case 2:
			searchStrning 
			break;
		case 3: System.out.println("프로그램 종료");
			break;
		default:
			 System.out.println("잘못된 메뉴입니다.");
		}
	}

	public static void searchString() {
		//단어 입력
		System.out.print("단어 입력 : ");
		String str = scan.next();
		
		//검색
		for(String tmp:list) {
			if(Pattern.matches(regex, str)) {
				System.out.println("영문자이고 3자입니다.");
			}else {
				System.out.println("영문자가 아니거나 3자가 아닙니다.");
			}

			if(imp!=null && tmp.cpnails(str)) {
				System.out.println(tmp);
			if(tmp!= null && tmp.index(str))=> 0{
				System.out.println(tmp);
			}
			}
			
		}
	}
	public static void insertString() {
		// 문장입력
		System.out.print("문장 입력 : ");
		scan.nextLine();//엔터처리
		String str =scan.nextLine();
		
		//문장을 추가
		list[count]= str;
		count++;
		
		
	}
	public static void printMenu() {
		System.out.println("----메뉴-----");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.println("-----------");
		System.out.println("메뉴 선택 : ");
		}
	
}
	/*	String str = "안녕하세요";
		String str2 = "테스트";
		String str3 ="만나서 반갑습니다.";
		String str4 ="나는 홍길동입니다.";
				
		Scanner scan= new Scanner(System.in);
		
		
	}
	@Override
	public void printMenu() {
	
		do {
				
		
			System.out.println("-----------");
			System.out.println("메뉴");
			System.out.println("1. 문장 추가");
			System.out.println("2. 검색");
			System.out.println("3. 종료");
			System.out.println("------------");
			
			}
	int menu;
	menu= scan. nextInt();		
	public void printMenu();
	public void runMenu();
		
	}
}
*/