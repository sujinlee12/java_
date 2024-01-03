package day17.student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //@Getter,@Setter,@ToString,@HashcodeAndEquals 등
@AllArgsConstructor//생성자. 모든 변수를 매개변수로 갖는 생성자를 만듬,requrie은 null
public class Student implements Serializable {

	private static final long serialVersionUID = 2677610515357292665L;

	private int grade, classNUm, num;
	private String name;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNUm == other.classNUm && grade == other.grade && num == other.num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classNUm, grade, num);
	}
	@Override
	public String toString() {
		return "["+ grade + "학년 "+  classNUm + "반"+ num +"번"+ name+"]";
	}
	
	
	
}
