package test;

import java.util.ArrayList;

public class Mycollection {

	public void test() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("사과"+"빨강"));
		list.add("메론"+ "초록");
		list.add("포도"+"보라");
		list.add("맛있는 과일");
		
		for(int i= 0; i <= list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
