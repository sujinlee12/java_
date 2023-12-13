package day04;

public class PrimeNumberEx1 {

	public static void main(String[] args) {
		/* 2부터 100사이의 모든 소수를 출력하는 코드를 작성하세요.
		 * 소수 판별 예제 이용(3일차: ForPrimeNumberEx1.java 참고)
		 *반복회수 : num는 2부터 100까지 1씩 증가
		 *규칙성 : num가 소수이면 num를 출력
		 **/
		for(int num=2; num <= 100; num++)
		
		
		//소수판별예제 구현
		
		/* 반복회수  : i는 1부터 num (정수)까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 약수의 개수를 1증가
		 * 		=> num를 i로 나누었을 때 나머지가 0과 같으면 count를 1증가
		 * 반복문 종료후: count가 2이면 소수, 아니면 소수가 아님이라고 출력.
		 */
		
		//num가 소수이면 num을 출력하는 예제
			for(int num = 2; num <= 100; num++) {
				int count = 0, i;
				for(i = 1; i<= num; i++) {
					if(num % i == 0) {
						count++;
					}
				}
				if(count == 2) {
					System.out.print(num + " ");
		}

			}

		}
}
}



