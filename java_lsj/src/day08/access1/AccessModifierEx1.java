package day08.access1;

public class AccessModifierEx1 {

	public static void main(String[] args) {
		Student std = new Student();
		//std.grade =1;//grade의 접근제어자가 private이어서 같은 패키지에 있는 클래스에서 사용 X
		std.classNum =1; // classNum의 접근제어자가 default이어서 같은 패키지에 있는 클래스에서 사용 O
		std.num=1; //num의 접근제어자가 public이어서 사용 가능 
	std.setGrade(1);
	std.classNum
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

}
