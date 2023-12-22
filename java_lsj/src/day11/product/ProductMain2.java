package day11.product;

import java.util.Scanner;

public class ProductMain2 {
	
	private static Scanner scan = new Scanner(System.in);

	private static Product[] list = new Product[10];
	private static int count =0;
	
	public static void main(String[] args) {
		/*제품을 관리하는 프로그램을 구현하세요.
		 * 메뉴
		 * 1.제품 입고(수정과 추가가 섞임)
		 * -제품을 판매하기 위해 다른 곳에서 제품을 구매
		 * 2.제품 판매
		 * -입고된 제품을 판매
		 * 3.제품 수정[가격]
		 * -일자별로 조회(구현 후)
		 * 4.매출 내역 조회
		 * 5.종료
		 * 
		 */	
		
		int menu;
		//반복문 : 프로그램 종료선택전까지
		do {	
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택 메뉴에 맞는 기능 실행
			runMenu(menu);
		}while(menu != 5);
		
		//프로그램 종료 안내 문구
		System.out.println("프로그램 종료!")

	}
	
	public static void printMenu() {
		System.out.println("메뉴 ");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정");
		System.out.println("4. 매출 내역");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	
	}

	public static void runMenu(int product) {
		switch(product) {
		case 1:
			//제품 등록 기능 구현
			insertproduct();
			break;
		case 2:
			//제품 검색 기능 구현
			searchproduct();
			break;
		case 3:
			//제품 수정 기능 구현
			updateproduct();
			break;
		case 4:
			//제품 삭제 기능 구현
			deleteproduct();
			break;
		case 5:
			System.out.println("프로그램 종료!");
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
				}
		}
	
	public static void insertWord() {
		
		//제품 등록
		System.out.print("제품명: ");
		String product = scan.next();
		
		System.out.print("수량 : ");
		scan.nextLine();//엔터 처리
		String mount = scan.nextLine();
		
		//제품과 수량의 인스턴스를 생성
		Word tmp = new Word(word, meaning);
		
		//위에서 생성한 인스턴스를 단어장에 저장
		list[count] = tmp;
		//저장된 단어의 개수를 1증가
		count++;
		
		//테스트용으로 단어장 목록 출력
		for(int i = 0; i<count; i++) {
			list[i].print();
		}
		
		
		
		
		//단어장이 꽉 차면 단어장 크기를 늘림
		if(count == list.length) {
			expandWordList();
		}
	}
	
	public static void updateWord() {
		//단어와 뜻을 입력
		System.out.print("단어 : ");
		String word = scan.next();
		System.out.print("의미 : ");
		scan.nextLine();//엔터 처리
		String meaning = scan.nextLine();
		
		//해당 단어의 뜻을 수정
		//반복문 : 저장된 개수만큼
		for(int i = 0; i<count; i++) {
			//입력한 단어와 단어가 같으면
			if(list[i].equals(word)) {
				//뜻을 수정하고 종료
				list[i].update(meaning);
				System.out.println("단어가 수정되었습니다.");
				return;
			}
		}
		//일치하는 단어 없다고 출력
		System.out.println("일치하는 단어가 없습니다.");
	}
	public static void deleteWord() {
		//제품명을 입력
		System.out.print("제품명 : ");
		String Product = scan.next();
		//단어장에서 단어를 삭제
		//삭제할 위치를 찾음
		//반복문 : 저장된 개수만큼
		int index = -1;//음수로 초기화. 배열의 번지는 0이상
		for(int i = 0; i<count; i++) {
			//입력한 단어와 같으면
			if(product[i].equals(word)) {
				//현재 위치를 index 저장
				index = i;
				break;
			}
		}
		
		
	
		//일치하는 제품이 없으면
		if(index == -1) {
			//안내문구 출력후 종료
			System.out.println("일치하는 제품이 없습니다.");
			return;
		}
		//저장된 단어의 개수를 1 줄임
		count--;
		System.out.println("삭제가 완료되었습니다.");
		//일치하는 단어가 마지막 단어이면
		if(index == count) {
			return;
			//종료
		}
		
		//한 칸씩 당겨오기
		//현재 배열과 같은 크기의 새 배열을 생성
		Word[] tmpList = new Word[List.length];
		
		//새 배열에 현재 배열을 복붙
		System.arraycopy(list, 0, tmpList, 0, list.length);
		
		//현재 배열에서 index+1번지부터 단어가 있는 마지막 번지까지
		//복사해서 새 배열에 index번지부터 복붙
		System.arraycopy(tmpList, index+1, list, index, count-index);
		
			}
	
		}
		
	
	
}
