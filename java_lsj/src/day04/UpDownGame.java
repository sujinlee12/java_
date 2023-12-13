package day04;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/* Up Down 게임을 구현하세요.
		 * - 다음과 같은 메뉴를 가져야 합니다.
		 * 1. 새게임
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 
		 * - 새게임은 업다운 게임을 시작
		 * 	-랜덤으로 생성된 수를 맞추는 게임
		 * 	- 맞췄을 때 맞춘 회수를 출력하고 메뉴로 돌아감
		 * - 최고기록 확인은 업다운 게임을 하면서 맞춘 횟수 중 가장 적은
		 *   횟수를 알려줌
		 **/
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 10000;
		int  = (int)( Math.random() * (max-min +1) + min);
		ch = scan.next().charAt(0);
		do {System.out.println("1. 새게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
		
		}while(r!=3);
	}
}
