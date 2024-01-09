package test;

public class Overloading {
	//오버로딩 시 클래스명을 오버로딩으로 설정할 수 없음
	public void test1() {}
	
	public void test(String str){}

	public void test(int i) {}
	
	public void test(String s, String m) {}
	
	public void test(char ch) {}

	public void test(String str, int i) {}
	
	public void test(int i, String str, int r) {}
	
	private void test(int i, int x) {}
	
	public int test() {return 0;}
	
}
