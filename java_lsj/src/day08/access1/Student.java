package day08.access1;

public class Student {
	private int grade;
	int classNum; // 접근제어자가 default
	Public int num;
	//grade가 private이어서 grade를 수정하기 위해 setter를 이용하여 수정
	std.setGrade(1);
	std.classNum =1;
	std.num=1;
	
		
	private String name;
	public int getGrade(1); {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}
