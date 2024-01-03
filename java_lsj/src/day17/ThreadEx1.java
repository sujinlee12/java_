package day17;

public class ThreadEx1 {

	public static void main(String[] args) {
		//싱글 쓰레드드라 앞에 작업이 끝나야 뒤에가 실행됨
		//싱글 쓰레드로 - 출력 후 + 출력
		for(int i =0; i<1000;i++) {
			System.out.print("-");
		}
		for(int i =0; i<1000;i++) {
			System.out.print("+");
		}
		System.out.println();
		
		//멀티 쓰레드로 쓰레드 1은 - 출력, 쓰레드 2는 +출력
		Thread t1 = new Thread1();
		t1.start();
		
		//Thread2 tmp = new Thread2();
		//Thread t2 = new Thread(tmp);
		
		Thread t2 = new Thread(new Thread2());
		t2.start();
	}

}

class Thread1 extends Thread{
	
	@Override
	public void run() {
		for(int i =0; i<1000;i++) {
			System.out.print("-");
		
		}
	}
	
}
class Thread2 implements Runnable{
	
	@Override
	public void run() {
		for(int i =0; i<50;i++) {
			System.out.println("+");
		}
	}
	
}
