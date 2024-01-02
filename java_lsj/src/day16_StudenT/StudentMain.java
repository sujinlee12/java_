package day16_StudenT;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentMain {
	
	static Scanner scan = new Scanner(System.in);
	static List <Student> list = new ArrayList<Student>();
	public static void main(String[] args) {
	
		/*다음 기능을 가진 프로그램을 만드세요.
		 * - 학생 관리프로그램
		 * - 기능
		 * 	1.학생 추가
		 * 	2.학생 조회
		 *  3.종료
		 *  -학생은 학년, 반, 번호, 이름을 가진다
		 *  -저장 기능과 불러오기 기능을 통해 학생 정보들을 유지
		 *  
		 */
		
		
		int menu = 0;
		String fileName = "src/day16/student/list.txt";
		load(fileName);
	do {
		try {
			//메뉴출력
			printMenu();
			//메뉴선택
			menu = scan.nextInt();
			//메뉴실행
			runMenu(menu);
			}catch(Exception e) {
			
			System.out.println("예외가 발생했습니다.");
			scan.nextLine();
			}
			
		}while(menu !=3);
		save(fileName);
	}
		
	private static void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		}catch(IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
		
	}

	private static void load(String fileName) {
		// TODO Auto-generated method stub
		
	}

	private static void runMenu(int menu) {
		
		switch(menu) {
			case 1:
				insertStudent();
				break;
			case 2:
				printStudent();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:	
				throw new RuntimeException();
			}
		
		}
		

	private static void printStudent() {
		
		list.stream().forEach(s->System.out.println(s));//*
		
		
				
	}

	private static void insertStudent() {
		//학년, 반, 번호 이름 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		
		System.out.print("반: ");
		int classNum = scan.nextInt();
		
		System.out.print("번호 : ");
		int num = scan.nextInt();
		
		System.out.print("이름 : ");
		String name = scan.next();
		
		//객체 생성
		Student std = new Student(grade, classNum, num,name);
		
		//같은 학생이 있는지 확인하고
		//없으면 학생 추가
		if(list.contains(std)) {
			list.add(std);
			System.out.println("학생을 추가했습니다.");
			return;
		}
		//있으면 안내 문구
			System.out.println("등록된 학생입니다.");
			
		if(map.containsKey(name1)) { //if(map.get(id) !=null)
			System.out.println("이미 가입된 학생입니다.");
			return;
			}
		//없으면 이름 입력
		System.out.println("이름 : ");
		System.out.println("학년 : ");
		System.out.println("반 : ");
		System.out.println("번호 : ");
		
		String pw = scan.next();
		
		
	
		
	

	private static void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 학생 추가 ");
		System.out.println("2. 학생 조회(전체)");
		System.out.println("3. 종료 ");
		System.out.println("---------------");
		System.out.println("메뉴 선택 : ");
		
	}
		
		
	}


