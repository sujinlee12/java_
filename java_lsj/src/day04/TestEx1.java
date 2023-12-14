package day04;

import java.util.Scanner;

public class TestEx1 {

	public static void main(String[] args) {
		/* Scanner를 이용하여 국어, 영어, 수학 성적을 입력받고,
		 * 총점과 평균을 구하는 코드를 작성하세요.*/
		 
		Scanner scan = new Scanner(System.in);
		
		// 성적을 입력받기 위한 안내 문구 출력 1
		System.out.print("성적을 입력하세요 (국어, 영어, 수학 순) : ");
		//성적을 Scanner를 통해 입력2
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		
		//성적의 총점과 평균을 계산
		int sum = kor + eng + math;
		double avg = (double)sum / 3;
		//평균은 정수 나누기 정수하면 안되므로 3.0으로 나누거나 형변환 double 해야함.
		
		//성적의 총점과 평균이 출력3
		System.out.println("총점 : "+ sum + ", 평균 : " + avg);
		scan.close();
		
			
					

	}

}
