package day04;

public class starEx4 {

	public static void main(String[] args) {
		/* 		*		i=1		' '=4 		*=1
		 *     ***      i=2		' '=3    	*=3
		 *    *****		i=3		' '=2		*=5	
		 *   ******* 	i=4		' '=1		*=7
		 *  ********** 	i=5		' '=0		*=9
		 *
		 */ 					//5-i			2*i-1
		
		
		for(int i = 1; i<=5;i++) {
			//' ' 출력 5-i개
			for(int j =1; j<=rows -i; j++) {
				System.out.println(' ');
			}
			//*출력 2*i-1개
			for(int j = 1; j<=2*i-1; j++) {
				System.out.print("*");
			}
			//엔터
			System.out.println();
		}
		
		/*		*      i=1  ' '=4	*=1
		 *     ** *    i=2  ' '=3	*=2
		 *    *** **   i=3  ' '=2	*=3
		 *   **** ***  i=4  ' '=1	*=4
		 *  ***** **** i=5  ' '=0	*=5
		 *  
		 *  */
		
			
			//내가 한 것
		/*int rows=9;
		for(int i=1; (i+2)<=rows;i++) {
			System.out.println('*');
		}
		for(int j=0; (j+2)<=rows; j++) {
			System.out.println(' ');
			**/
		}		
	}



