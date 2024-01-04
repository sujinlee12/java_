import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeworkEx1 {

	private static Scanner scan = new Scanner(System.in);
	private final int EXIT = 4;
        public static void main(String[] args) {
            /* 영어 단어장을 관리하는 프로그램을 작성하세요.
             * 기한은 1/5까지 github에 업로드 후 강사에게 공유(단톡방)
             *
             * -한 단어에 뜻이 여러개 있을 수 있음.
             * -단어, 품사, 뜻을 관리
             * -단어 추가
             * -단어 수정
             * -단어 삭제
             * -뜻 추가
             * -뜻 수정
             * -뜻 삭제
             * -단어 조회
             *
             * -기타 추가 기능을 구현해도 됨
             * -등록된 단어장에서 랜덤으로 문제가 나오고 맞추는 기능
             * - 오답 노트를 관리해주는 기능
             * -많이 조회한 단어를 확인하는 기능
             * */
        	
        	//단어 추가
        	public void run() {
        		int menu =0;
        		printmenu();
        		try {
        			//메뉴선택
        			menu = scan.nextInt();
        			//메뉴실행
        			runMenu(menu);
        		}catch(InputMismatchException e) {
        			System.out.println("잘못된 메뉴입니다.");
        			scan.nextLine();
        		}
        	
        		}
        		}while(menu!=EXIT);
        
        
        	
			
        	/*단어 수정
            System.out.println("수정할 단어 : ");
            word = scan.nextLine();
            if (map.containsKey(word)) {
                System.out.println("단어 수정 : ");
                String changeWord = scan.nextLine();
                map.put(changeWord,map.remove(word));
            }else {
            	System.out.println("없는 단어 입니다.");
            }
            break;
            	
               	int menu;
                
               	do {
                	//메뉴 출력
                	printmenu();
                    //메뉴 선택
                    menu = scan.nextInt();
                    //선택 메뉴에 맞는 기능 실행
                    runMenu(menu);

               		}while(menu != 5);

               		//프로그램 종료 안내 문구
               		System.out.println("프로그램 종료!");

            }*/
        		
		@Override
		private static void runMenu(int menu) {
			switch(menu) {
			case 1 :
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("프로그램 종료");
				break;
			default:
				throw new InputMismatchException();
			}
			
		}

		private static void printmenu() {
			/*단어 추가
            * -단어 수정
            * -단어 삭제
            * -뜻 추가
            * -뜻 수정
            * -뜻 삭제
            * -단어 조회*/
			
			System.out.println("---메뉴----");
			System.out.println("----단어---");
			System.out.println("1.단어 추가");
			System.out.println("2.단어 수정");
			System.out.println("3.단어 삭제");
			System.out.println("----뜻----");
			System.out.println("4.뜻 추가");
			System.out.println("5.뜻 수정");
			System.out.println("6.뜻 삭제");
			System.out.println("7.단어 조회");
			System.out.println("메뉴 선택 : ");
			
			//메뉴선택
			int menu = scan.nextInt();
			
			//기능실행
			
			
		}

            
