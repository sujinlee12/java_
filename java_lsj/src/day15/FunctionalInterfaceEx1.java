package day15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FunctionalInterfaceEx1 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1,1,1,"홍길동",90,80,70));
		list.add(new Student(1,1,2,"임꺽정",100,100,100));
		list.add(new Student(1,1,3,"고길동",50,50,50));
		

		print(list,s->{
			System.out.println(s.getGrade()+"학년"+ s.getClassNum()+"반"
					+s.getNum()+"번호"+ s.getName());		
		});
		
		print(list,s->{
			System.out.println(s.getName()+":국어 -"+ s.getKor()
			+", 영어 -"+ s.getEng()
			+", 수학 -" + s.getMath());
		});
		
		//학생들의 국어 총점
		System.out.print("국어");
		printTotalScore(list,s->s.getKor());
			
		//학생들의 영어 총점
		System.out.print("영어");
		printTotalScore(list,s->s.getEng());
		//학생들의 수학 총점		
		System.out.print("수학");
		printTotalScore(list,s->s.getMath());
		
		//1학년 학생들의 정보를 출력	
		printStudent(list, (s)->s.getGrade() == 1);
		System.out.println("-------------------");
		//국어 성적이 60점 이상인 학생들의 정보를 출력
		printstudent(list,s->s.getKor()>=60);
		System.out.println("-------------------");
		//평균이 85점 이상인 학생들의 정보를 출력
		printStudent(list, s->(s.getKor()+s.getMath()+s.getEng())/3.0>=85);
		
		
		
	}
	


	public static void printTotalScore(List<Student> list,Function<Student,Integer> fn;
	
		int total =0;
		for (Student std : list) {
			total += fn.apply(std);
		}
		System.out.println("총점 : "+total);

			
			}
			public static void printStudent(List<Student>list, Predicate<Student>p) {
				for(Student std : list) {
					if(p.test(std)) {
						System.out.println(std);
					}
				}
			}
		
		}

@Data
@AllArgsConstructor
class Student{
	int grade,classNum,num;
	String name;
	int kor,eng,math;
}
