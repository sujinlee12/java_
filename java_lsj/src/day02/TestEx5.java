package day02;

import java.util.Scanner;

public class TestEx5 {

	public static void main(String[] args) {
		/*월을 입력받아 입력받은 월의 계절을 출력하세요.
		 * 3,4,5 : 봄
		 * 6,7,8 : 여름
		 * 9,10,11 : 가을
		 * 12,1,2 : 겨울
		 * 그 외 : 잘못된 월
		 * */
		Scanner scan = new Scanner(System.in);
		//안내문구
		System.out.println("계절을 입력하세요 : ");
		int month = scan.nextInt();
		
		if(month < 1 || month >12) {
			System.out.println(month + "월은 잘못된 월");
		}else if(month <=2 || month == 12) {
			System.out.println(month + "월은 겨울");
		}else if(month <=5) {
			System.out.println("월은 봄");
		}else if(month <=8) {
			System.out.println(month + "월은 여름");
		}else {	
			System.out.println(month + "월은 가을");
		}
		
		scan.close();
		
	}

}
