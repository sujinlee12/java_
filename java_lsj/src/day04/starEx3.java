package day04;

public class starEx3 {

	public static void main(String[] args) {
		/* 		 * ' '=4 	*=1
		 * 	    ** ' '=3	*=2
		 *	   *** ' '=2	*=3
		 *    **** ' '=1	*=4
		 *   ***** ' '=0	*=5
		 *
		 *	   ' '=5-1	*=i개
		 **/
		int rows=5;
		
		for(int i=1;i<= rows; i++) {
			//' '을 5-i개 출력
			for(int j = 1; j<=rows-i; j++) {
				System.out.print(' ');
			}
			//*을 i개 출력
			for(int j =1; j<=i; j++) {
				System.out.print("*");
			}
			
			//엔터
			System.out.println();
		}
		
	}

}
