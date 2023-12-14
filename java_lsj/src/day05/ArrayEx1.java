package day05;

import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/*int kor1, kor2, kor3, kor4, kor5;
		 * 
		 * 
		 * 
		 * 
		 //아래 반복문은 변수명에 
		 * 
		 * for(int i= 1;i<=5;i++){
		 * 	kori=scan.nextInt();
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		// 학생 5명의 국어 성적을 저장하기 위한 배열
		int [] korScores = new int [5];
		
		/*
		korScores[0] = scan.nextInt();
		korScores[1] = scan.nextInt();
		korScores[2] = scan.nextInt();
		korScores[3] = scan.nextInt();
		korScores[4] = scan.nextInt();
		**/
		
		for(int i = 0;i<=4;i++) {
			System.out.print("학생"+ (i+1)+ "성적 : ");
			korScores[i] = scan.nextInt();
		}
		
		for(int i=0;i<=4;i++) {
			System.out.println("학생" + (i+1) + "성적 : "+ korScores[i]);
		}
		scan.close();
		

	}

}
