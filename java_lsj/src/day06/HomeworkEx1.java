package day06;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/* 	숫자 야구 게임을 구현하세요
		 * - 1~9 사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
		 * - S : 숫자가 있고, 위치가 같은 경우 
		 * - B : 숫자가 있지만 위치가 다른 경우
		 * - O : 일치하는 숫자가 하나도 없는 경우
		 * - 3S가 되면 게임이 종료
		 * 
		 *  예시
		 *  랜덤으로 생성된 숫자 : 3 9 1
		 *  입력 : 1 2 3
		 *  결과 : 2B
		 *  입력 : 4 5 6
		 *  결과 : O
		 *  입력 : 7 9 8
		 *  결과 : 1S
		 *  입력 : 3 1 9
		 *  결과 : 1S2B
		 *  입력 : 3 9 1
		 *  결과 : 3S
		 *  정답입니다.
		 **/
		String tmp = "y";
		
		int min =1, max=9;
		int i;
		while(tmp.equals("y")) {
			System.out.println("숫자 야구게임을 시작합니다. :");
		
		int com[]=new int [3];//랜덤한 값을 넣기 위한 배열 (컴퓨터 값)
		int user[]= new int [3];//사용자 입력값의 각 자리 숫자를 넣기 위한 배열
		int num=0;//배열 인덱스를 위해 사용하는 변수
		int count=0;//몇번에 맞추는 지 세기위해
		boolean loop = true;
		
		int O=0;//count=0
		
		
		for(i=0; i<com.length;i++) {
			com[i] = (int)(Math.random()*9)+1;
			for(int j=0;j<i;j++) {
				if(com[j]==com[i]) {
					i--;
					break;
				}
			}		
		}
		
		//user가 세개의 정수를 입력하도록 하여,user 배열에 숫자를 넣도록 한다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1~9의 정수를 입력하세요");
		
		// computer와 user의 배열을 비교하여 구분
		
		loop = true;
		
		while(loop) {
			for(i=0;i<user.length;i++) {
				num=sc.nextInt();
				user[i]=num;
				if(num<0||num>10) {
					System.out.println("1~9의 정수를 입력하시오");
				}
			}	for(i=0;i<com.length;i++) {
				for(int j=0;j < user.length;j++)
					if(com[i]==user[j] && i==j) {
					System.out.println("strike++");
					
			}else if(com[i]==user[j]&&i !=j) {
				System.out.println("ball++");
				
			}else {
				System.out.println("탈락입니다.");
				
			}
			}
		}}}}
	
	
		
		

		
		
		
		
		
		
		
		



