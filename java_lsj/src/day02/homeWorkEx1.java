package day02;

import java.util.Scanner;

public class homeWorkEx1 {

	public static void main(String[] args) {
		/* 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * 90이상 ~ 100이하 : A
		 * 80이상 ~ 90미만 : B
		 * 70이상 ~ 80미만 : C
		 * 60이상 ~ 70미만 : D
		 * 60미만 : F
		 * 0보다 작거나 100보다 큰 경우 : 잘못된 점수
		 **/
		Scanner scan = new Scanner(System.in);
		System.out.println("성적을 입력하시오 (예: 90점) : ");
		int Score = scan.nextInt();
		
		if(Score < 0 || Score >100) {
			System.out.println(Score + "은 잘못된 점수입니다.");
		}else if(Score < 60) {
			System.out.println(Score + "은 F입니다.");
		}else if(Score>=60 && Score<70) {
			System.out.println(Score + "은 D입니다.");
		}else if(Score>=70 && Score<80) {
			System.out.println(Score + "은 C입니다.");
		}else if(Score>=80 && Score<90) {
			System.out.println(Score + "은 B입니다.");
		}else if(Score>=90 && Score<=100) {
			System.out.println(Score + "은 A입니다.");}
		scan.close();
		
	}
}

		

	

