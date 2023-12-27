package day13;

import java.util.Calendar;

public class CalenderEx1 {

	public static void main(String[] args) {
		// 캘린더 예제
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		System.out.println(year + "년");
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println(month + "월");
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.print(day + "일");
		
	}

}
