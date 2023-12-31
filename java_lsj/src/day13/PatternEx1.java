package day13;

import java.util.regex.Pattern;

public class PatternEx1 {

	/*^[abc]$
-한 글자이고, a나 b나 c인경우만 참

^[abc]+$
-문자열이 abc로만 되어 있고, 1글자 이상인 경우

^[a-z]$
-한 글자이고, A~Z인 경우

^\d$
숫자 하나, 0-9

^\d{3,5}$
-3~5자

^\d{3,}$
-숫자 3이상

^\d{3}$
-숫자 3자

^(010|011|012)$
-010,011,012인 경우

아이디는 영문,숫자로 구성되어있고,8~13인 경우를 확인하는 정규표현식을 작성하세요.
문자열이 영문 5~8자리인 경우를 확인하는 정규 표현식을 작성하세요.
^[a-zA-Z]{5,8}$

^[a-zA-Z0-9]{8,13}$

^\w{8,13}$

url인지 아닌지 판별하기 위해 문자열의 시작이 https 또는 http가 맞는지를 확인하는 정규표현식을 작성하세요.
^https?://[a-zA-Z0-9\.]+$

^[^abc]$
abc가 아닌 한 글자를 의미.
	 *
	 * 
	 */
	public static void main(String[] args) {
		//pattern 클래스를 이용하여 문자열이 정규표현식에 맞는지 확인 예제
		String str = "abcde";
		String regex = "^[a-zA-Z]{3}$";//영문자이고 3자
		if(Pattern.matches(regex, str)) {
			System.out.println("영문자이고 3자입니다.");
		}else {
			System.out.println("영문자가 아니거나 3자가 아닙니다.");
		}

	}

}
