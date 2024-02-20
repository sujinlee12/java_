package kr.kh.community.main;

import java.util.Scanner;

import kr.kh.community.controller.CommunityController;

public class Main {

	private static CommunityController communityController; 
		int menu;
		Scanner scan = new Scanner (System.in);
		communityController = new CommunityController(scan);
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu();
			}
		private void printMenu() {
			System.out.println("메뉴");
			System.out.println("1. 게시판 관리");
			System.out.println("2. 프로그램 종료");
			System.out.println("메뉴 선택 : ");
		}
		private void runMenu() {
			switch(menu) {
			case 1:
				communityController.run();
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
			
			}while(menu != 2);
		
		
	
}
