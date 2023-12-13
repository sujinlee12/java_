package day04;

import java.util.Scanner;

public class DoWhileMenuEx1 {

	public static void main(String[] args) {
		/*  메뉴를 출력하는 예제 
		 *  메뉴
		 *  1. 새게임
		 *  2. 최고기록 확인
		 *  3.프로그램 종료
		 *  메뉴선택 : 1
		 *  메뉴
		 *  1. 새 게임
		 *  2. 최고기록 확인
		 *  3. 프로그램 종료
		 *  메뉴 선택 : 2
		 *  메뉴
		 *  1.새게임
		 *  2.최고기록 확인
		 *  3.프로그램 종료
		 *  메뉴 선택: 3
		 *  프로그램 종료
		 *  */
		
		
		 // 반복문 _ 메뉴를 출력
			//메뉴를 출력
			//메뉴를 선택
			//선택한 메뉴에 따라 기능을 실형
		//반복문 -
		
		
		//정수 입력
		//입력한 정수와 랜덤한 수 비교후 up/down/정답 출력
		//입력 횟수를 1증가
		//입력한 정수와 랜덤한 수 비교 후 up/down/정답을 출력
		//게임이 끝났으면 현재 횟수가 최고기록 회수보다 좋으면
		//최고 기록 횟수를 현재 횟수로 수정
		
		//1번 메뉴 선택
			//업다운 게임을 실행
		//2번메뉴 선택
			// 최고기록을 출력
		//3번 메뉴 선택
		//count 횟수, best count 최고기록, 실제 플레이할 때 나올 수 없는 값.
		Scanner scan = new Scanner(System.in);
		int menu;//메뉴
		int count, bestCount = -1;//게임 플레이 횟수, 최고기록
		int random;//랜덤한 수
		int num;//입력한 정수
		int max = 100, min = 1;//랜덤 수 범위
		//반복문 -
		do {
			//메뉴를 출력
			System.out.println("---------");
			System.out.println("메뉴");
			System.out.println("1. 새게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.println("---------");
			System.out.println("메뉴 선택 : ");
			//메뉴를 선택
			menu = scan.nextInt();
			//선택한 메뉴에 따라 기능을 실행
				switch(menu) {
				
				case 1:
					//업다운 게임을 실행
					//랜덤한 수 생성
					
					random =(int)(Math.random()*(max - min+1)+min);
					System.out.println("랜덤 : "+ random);
					//반복문
					count = 0;
					do {
						//정수 입력
						System.out.println("입력 : ");
						num =scan.nextInt();
						//입력횟수를 1증가
						count++;
						//입력한 정수와 랜덤한 수 비교 후 up/down/정답 출력
						if(num > random) {
							System.out.println("Down!");
							
						}else if(num < random) {System.out.println("up!");
							
						}else {
							System.out.println("정답!");
						}
						
					//현재 기록을 출력
					System.out.println("기록 : " + count);
					//게임이 끝났으면 현재 횟수가 최고기록 횟수보다 좋으면
					if(bestCount == -1 || count < bestCount) {
						//최고 기록 횟수를 현재 횟수로 수정
						bestCount = count;
					}
					break;
					//2번 메뉴 선택
				case 2:
					//최고 기록을 출력
					if(bestCount == -1) {
						System.out.println("플레이한 기록이 없습니다.");
						break;
					}
					 System.out.println("최고 기록 : " + bestCount);
					 break;
					//최고기록을 출력
					
					//3번 메뉴 선택
				case 3:
					System.out.println("프로그램을 종료합니다.");
					break;
									
				}

		}while (menu != 3);
			
	}


