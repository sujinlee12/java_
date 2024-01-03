package day17.student;

import java.util.ArrayList;

import lombok.Data;


@Data
public class StudentManager {

	
	private ArrayList<Student> list = new ArrayList<Student>();
	
	/**	학생 정보가 주어지면 학생 정보를 추가하는 메서드로, 
	 * 학년, 반, 번호가 같은 학생이 있는 경우 학생 정보를 추가하지 않음
	 *@param student 학생정보 
	 *@return 학생 정보를 추가했는지에 대한 여부
	 */
	public boolean insertStudent(Student std) {
		if(list.contains(std)) {
			return false;
		}
		
		list.add(std);
		//학년, 반, 번호 순으로 정렬
		sort();
		
		return true;
	}
	/**가지고 있는 학생 정보들을 정렬하는 메서드
	 * 
	 */
	public void sort() {
		list.sort((s1, s2)->{
			if(s1.getGrade() != s2.getGrade()) {
				return s1.getGrade() - s2.getGrade();
			}
			if(s1.getClassNUm() != s2.getClassNUm()) {
				return s1.getClassNUm() - s2.getClassNUm();
			}
			return s1.getNum() - s2.getNum();
		});
		
	}
	//학생 정보 출력
	public void printAll() {
		list.stream().forEach(s->System.out.println(s));
	
	}
	
	public void setList(ArrayList<Student>lit) {
		if(list == null) {
			return;
		}
		this.list = list;
	}

}


