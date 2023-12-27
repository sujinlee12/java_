package day13;

public class InterfaceEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(KiaCar.brand);
		//인스턴스 생성 없이 호출이 가능한 static.
		Printer.print();
		//반드시 구현이 되어야함.static
	}

}
class KiaCar{
	public static String brand = "기아";
	
}
interface Printer{
	//static이 붙은 메서드는 반드시 구현해야함.
	static void print(){
		System.out.println("프린터입니다.");
	}
	//static이 안붙은 메서드는 추상메서드로 만들어서 구현하지 않거나
	void test();
	//default 메서드로 만들어서 구현
	default void test2() {}
}
