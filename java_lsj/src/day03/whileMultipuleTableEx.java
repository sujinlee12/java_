package day03;

public class whileMultipuleTableEx {

	public static void main(String[] args) {
		/*구구단 2단을 출력하는 코드를 작성하세요.
		 * 2 X 1 = 2
		 * 2 X 2 = 4
		 * ...
		 * 2 X 9= 18
		 * 반복 회수 :i는 1부터 9까지 1씩 증가
		 * 규칙성 :2 x 1 = 2 * i를 출력
		 * 반복문 종료 후: 없음
		 */
		int num = 2;
		int i = 1;
		while (i <= 9) {
			System.out.println(num + "X" + i + "=" + num * i );
			i++;
		}
		
	}

}
