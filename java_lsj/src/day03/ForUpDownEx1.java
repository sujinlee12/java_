package day03;

import java.util.Scanner;

public class ForUpDownEx1 {

	public static void main(String[] args) {
		/* 숫자 업다운 게임을 작성하세요
		* 랜덤으로 생성된 숫자를 맞추는 게임
		* 예시
		* 랜덤으로 생성된 숫자 : 30
		* 정수 : 50
		* Down!
		* 정수 : 20
		* Up!
		* 정수 : 30
		* 정답!
		**/
		//랜덤한 수 생성
		
		//반복문	: 조건식만 입력
			//정수 입력
			//정수와 랜덤한수를 비교 후 결과를 출력
			//랜덤한 수 생성 : 1 ~100
			
		int min = 1, max = 10000;
			int r = (int)( Math.random() * (max-min +1) + min);
		
			
			Scanner scanner = new Scanner(System.in);
				int num = min - 1;
		
				for( ;num !=r;) {
		
					System.out.println("정수 : ");
					num= scanner.nextInt();
		//정수의 랜덤한 수를 비교 후 결과를 출력
		if(num > r) {
			System.out.println("Down!");
		}else if (num < r) {
		System.out.println("up!");
		}else { System.out.println("정답입니다!!");}
			
			}
		}

	}
