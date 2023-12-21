package day10.word;

import java.util.Scanner;


public class WordMain {
	private static Scanner scan = new Scanner(System.in);
	
	private static Word [] WordList = new Word[10];//단어장
	private static int count = 0; //저장된 단어 개수

	//영어 단어장 프로그램을 반드세요
	public static void main(String [] args){
	public static void printMenu() {
	public static void runMenu(int menu) {
			switch(menu) {
			case 1:
				//단어 등록 기능 구현
				insertWord();
				break;
				case 2:
					System.out.println(count);
					
					//단어 검색 기능 구현
					searchWord();
					break;
				case 3:
					//단어 수정 기능 구현
					updateWord();
					break;
				case 4:
					//단어 삭제 기능 구현
					deleteWord();
					break;
				default:
					System.out.println("종료");
					
									}
		
	}
	
		
			public static void insertWord() {
			public static void expanWordList() {
			public static void searchWord() {
			public static void updateWOrd() {
				//단어와 뜻을 입력
				System.out.print("단어 : ");
				String word = scan.next();
				System.out.print("의미 : ");
				scan.nextLine();//엔터 처리
				String meaning = scan.nextLine();
				
				
				//해당 단어의 뜻을 수정
				//반복문 : 저장된 개수만큼
				for(int i= 0; i<count;i++) {
					//입력한 단어와 단어가 같으면 
					if(list[i].equals(word)) {
						//뜻을 수정하고 종료
						List[i].update(meaning);
						System.out.println("단어가 수정되었습니다.");
						return;
					}
				}
				//일치하는 단어가 없다고 출력
				System.out.println("일치하는 단어가 없습니다.");
			}
			public static void deleteWord() {
				//단어를 입력
				System.out.print("단어 : ");
				String word = scan.next();
				//단어장에서 단어를 삭제
				//삭제할 위치를 찾음
				//반복문 : 저장된 개수만큼 반복
				int index = -1;//음수로 초기화. 배열의 번지는 0이상
				for(int i=0;i<count;i++) {
					//입력한 단어와 같으면 
					if(List[i].equals(word)) {
						//현재 위치를 index 저장
						index=i;
						break;
					}
				}				
				//일치하는 단어가 없으면 
						
				if(index ==-1) {
					System.out.println("일치하는 단어가 없습니다.");//안내문구 출력 후 종료
					return;
				}
				//저장된 단어의 개수를 1 줄임
				count--;
				System.out.println("삭제가 완료되었습니다.");
				//일치하는 단어가 마지막 단어이면
				if(index==count) {
					return;
					//종료
				}
				//한 칸씩 당겨오기
				//현재 배열과 같은 크기의 새 배열을 생성
				Word[] tmpList = new Word[list.length];
				
				//새 배열에 현재 배열을 복붙
				System.arraycopy(List, 0, tmpList, 0, List.length);
				
				//현재 배열에서 index+1번지부터 단어가 있는 마지막 번지까지
				//복사해서 새 배열에 index번지부터 복붙
				System.arraycopy(tmpList, index+1, List, index, count-index);
				//1 2 3 4
				//index=0,count =3
				
				}
			}						
				
					
			
			
			
			
			//단어와 뜻 입력
			System.out.print("단어 : ");
			String word = scan.next();
			
			System.out.print("의미 : ");
			scan.nextLine();//엔터 처리
			String meaning= scan.nextLine();
			
			//단어와 뜻을 이용하여 word의 인스턴스를 생성
			Word tmp = new Word(word,meaning);
			
			//위에서 생성한 인스턴스를 단어장에 저장
			List[0] = tmp;
			//저장된 단어의 개수를 1증가
			count++;
			
			//테스트용으로 단어장 목록 출력
			for(int i=0;i<count;i++) {
				List[i].print();

			}
			//단어장이 꽉 차면 단어장 크기를 늘림
			if (count == List.length) {
				expandWordList();
			}
		}
		public static void expandWordList() {
			//기존 단어장보다 큰 단어장 생성
			word[] tmpList = new Word[List.length+10];
			//새 단어장에 기존 단어들을 복붙
			System.arraycopy(List,0,tmpList,0,count);
			//새 단어장을 내 단어장이라고 선언
			List = tmpList;
		}
	}			
	
	//public static void Wordmain(String[] args) {
		int menu;
		//반복문
		do {
			//메뉴출력
			printMenu();
		//메뉴 선택	
			
		//선택한 메뉴에 맞는 기능 실행 
			runMennu(menu);
			
		}while(menu != 5);
			public static void printMenu() {
			System.out.println("------------");
			System.out.println("1. 단어등록 ");
			System.out.println("2. 단어검색 ");
			System.out.println("3. 단어수정 ");
			System.out.println("4. 단어삭제 ");
			System.out.println("5. 종료 ");
			System.out.println("-------------");
			System.out.println(" 메뉴 선택 : ");
		}
	
	}
		
		
			//검색할 단어입력
			System.out.print("단어 : ");
			String word = scan.next();
			//단어장에서 검새해서 결과를 출력
			//반복문 : 저장된개수만큼
			for(int i = 0; i<count;i++) {
				//단어장에 단어가 주어진 단어와 일치하면
			if(List[i].equals(word)]) {
				//출력 후 종료
				List[i].print();
				return;
				}
			}
			//단어가 없다고 출력
			System.out.println("일치하는 단어가 없습니다.");
		}
			
	}
		
		
		//private static Scanner scan = new Scanner(System.in);
		
		/*private static Woard [] WordList = new Word[10];//게시글 목록
		/*private static int WordNum = 1;//추가될 게시글 번호
		private static int count = 0;//현재 등록된 게시글 개수
		
		public static void main(String[]args) {
			
			//반복문
			int wordList;
			do {
				//메뉴 출력
				printMenu();
				//메뉴 선택
				menu = scan.nextInt();
				//선택한 기능 실행
				runMenu(menu);
				
			}wile(menu !=3);
		} 
		/**menu가 주어지면 menu에 맞는 기능을 실행하는 메서드
		 * 실행할 메뉴의 번호
		 */
		/*private static void runMenu(int menu) {
			switch(menu) {
			case 1:
				//runBoard();
				//게시글 목록을 출력. 번호가 높은 순으로
				for(int i= count-1;i>=0;i--) {
					//A는 초기값 : count-1
					//B는 비교연산자: >=
					//C는 값 : 0
					//D는 증감연산식 : i--
					WoardList[i].printInfo();
				}
				//서브메뉴를 출력
				printSubmenu();
				//서브메뉴 선택
				int submenu= scan.nextInt();
				//서브메뉴 맞는 기능 실행
				runSubmenu(submenu);
				break;
			case 2:
				
				//게시글 등록 기능을 구현
				insertBoard();
				break;
			case 3:
				System.out.println("단어장을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			
			}
				
		}
		private static void runSubmennu(int submenu) {
			switch(submenu) {
			
			case 1:
				//게시글 상세 조회
				printBoardDetail();
				break;
			case 2:
				//게시글 수정
				updateBoard();
				break;
			case 3:
				//게시글 삭제
				deleteBoard();
				break;
			case 4:
				System.out.println("이전으로 돌아갑니다.");
				break;
			default:
				System.out.println("잘못 선택하셨습니다.");
			}
		}
		private static void deleteBoard() {
			System.out.print("삭제할 게시글 번호 : ");
			
		//생성자 : 영어단어 번호, 단어, 뜻
			public Word (int num, String EngWord, String korWord)
			this.num = num;
			this.Engword;
			this.contents;
			this.clone()
			
			/* 영어 단어장 프로그램을 만드세요.
			 * 1. 기능 정리
			 * - 단어는 영어 단어와 한글 뜻으로 구성 
			 * - 영어 단어는 영어이고, 공백이 없는 단어
			 * - 한글 뜻은 한글이고, 한 문장으로 되어 있다.
			 * - 한 단어에 뜻이 한개만 있다고 가정
			 * - 기능
			 * 		-단어 등록
			 * 		-단어 검색
			 * 		-단어 수정
			 * 		-단어 삭제 
			 *- word 클래스
			 *	- word : 영단어
			 *	- meaning : 뜻
			 *	- 단어 출력, 단어 수정, 단어 확인 : 주어진 문자열과 같은 단어인지 확인
			 *	//주어진 단어와 뜻으로 단어와 뜻을 초기화 하는 생성자
			 * 2. 틀작성
			 * 
			 * 
			 * 3. 필요한 메서드 구현
			 */
		
			
			
		
	