package day03;

public class SwtichEx1 {

	// swtich문 예제 
	public static void main(String[] args) {
		/* 정수가 0인지 아닌지 판별하는 예제 */
		int num = 10;
		//조건식이 아니라 식 또는 변수
		
		switch (num) {
		case 0:
			System.out.println("0입니다.");
			break;
		default :
			System.out.println(num + "는 0이 아닙니다.");
	}

	}
	
}
