package word;

import java.util.InputMismatchException;
import java.util.Scanner;

import day17.student.Program;
import word.service.PrintService;
import word.service.PrintServiceImp;

public class WordProgram implements Program {

	private final int EXIT = 4;
	private final int WORD_EXIT = 4;
	private final int MEAN_EXIT = 4;
	private final int GAME_EXIT = 4;
	
	private Scanner scan = new Scanner(System.in);
	private PrintService printService = new PrintServiceImp();
	//빈 단어장 만들기
	private Vocabulary vocabulary = new Vocabulary(null);
	
	@Override
	public void run() {
		int menu = 0;
		do {
			try {
				printMenu();
			
				//메뉴 선택
				menu =scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				//메뉴를 잘못 입력하면 입력 버퍼에 잘못 입력된 메뉴가 남아있어서 비워줘야 함.
				//비워주지 않으면 무한 루프 발생
				scan.nextLine();
			}
		}while(menu != EXIT);

	}

	@Override
	public void printMenu() {
		printService.printMainMenu();
	
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			wordManage();
			break;
		case 2:
			meanManage();
			break;
		case 3:
			gameManage();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}

	}

	private void gameManage() {
		// TODO Auto-generated method stub
		
	}

	private void meanManage() {
		int menu;
		do {
			// 뜻 관리 메뉴 출력
			printService.printMeanMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			// 메뉴 실행
			runMeanMenu(menu);
		}while(menu != MEAN_EXIT);
	}

	private void runMeanMenu(int menu) {
		switch(menu) {
		case 1:
			addMean();
			break;
		case 2:
			setMean();
			break;
		case 3:
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
			
		}
		
	}

	private void setMean() {
		//단어 입력
		System.out.println("단어 : ");
		scan.nextLine();
		String word = scan.nextLine();
		//입력한 단어와 일치하는 단어 객체를 가져옴
		Word selectedWord = vocabulary.getWord(word);
		//없는 단어이면
		if(selectedWord == null) {
			System.out.println("등록되지 않은 단어입니다.");
			return;
		}
		
		//입력한 단어의 뜻을 출력
		selectedWord.printWord();
		//수정할 뜻 선택
		int index = scan.nextInt() -1;
		
		//수정할 품사, 뜻을 입력
		System.out.println("수정할 품사 : ");
		String partOfSpeech = scan.next();
		System.out.println("수정할 의미 : ");
		scan.nextLine();//엔터처리
		String mean = scan.nextLine();
		//뜻을 수정
		if(selectedWord.setMean(index, partOfSpeech, mean)) {
			System.out.println("의미를 수정했습니다.");
		}else {
			System.out.println("의미를 수정하지 못했습니다.");
		}
		System.out.println(vocabulary);
	}
	private void addMean() {
		//뜻을 추가할 단어 입력, 품사, 뜻 입력
		System.out.print("단어 : ");
		scan.nextLine();//엔터 처리
		String word = scan.nextLine();
		System.out.print("품사 : ");
		String partOfSpeech = scan.next();
		System.out.print("의미 : ");
		scan.nextLine();//엔터 처리
		String mean = scan.nextLine();
		
		//뜻 추가
		if(vocabulary.addMean(word,partOfSpeech,mean)) {
			System.out.println("새 의미를 추가했습니다.");
		}else {
			System.out.println("새 의미를 추가하지 못했습니다.");
		}
		System.out.println(vocabulary);
	}

	private void wordManage() {
		int menu;
		do {
			//단어 관리 메뉴 출력
			printService.printWordMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//메뉴 실행
			runWordMenu(menu);
		}while(menu != WORD_EXIT);
		
	}

	private void runWordMenu(int menu) {
		switch(menu) {
		case 1:
			addWord();
			break;
		case 2:
			setWord();
			break;
		case 3:
			removeWord();
			break;
		case 4:
			System.out.println("이전 메뉴로 돌아갑니다.");
			break;
		default:
			throw new InputMismatchException();
			
		}
		
	}

	private void removeWord() {
		//삭제할 단어 입력
		System.out.println("삭제할 단어 : ");
		scan.nextLine(); //입력버퍼 엔터 처리
		String word = scan.nextLine();
	
		//단어 삭제
		if(vocabulary.removeWord(word)) {
			System.out.println("단어를 삭제했습니다.");
		}else {
			System.out.println("없는 단어입니다.");
		}
	}

	private void setWord() {
		//수정할 단어와 새 단어를 입력
		System.out.println("수정할 단어 : ");
		scan.nextLine();//엔터 처리
		String oldWord = scan.nextLine();
		System.out.println("새 단어 : ");
		String newWord = scan.nextLine();
		
		//단어를 수정
		if(vocabulary.setWord(oldWord, newWord)) {
			System.out.println("단어를 수정했습니다.");
			
		}else {
			//없는 단어를 수정하려고 했거나 이미 등록된 단어로 수정하려고 할 때
			System.out.println("단어를 수정하지 못했습니다.");
		}
	}

	private void addWord() {
		//단어, 품사, 뜻을 입력
		System.out.println("단어 : ");
		scan.nextLine(); // 이전에 입력한 엔터를 처리
		String word = scan.nextLine();
		System.out.println("품사 : ");
		String partOfSpeech = scan.next();
		System.out.println("의미 : ");
		scan.nextLine();
		String mean = scan.nextLine();
		
		//단어장이 비어 있으면
		if(vocabulary == null) {
			System.out.println("단어장이 없습니다.");
			return;
		}
		
		//단어장에 추가
		if(vocabulary.addWord(word, partOfSpeech, mean)){
				System.out.println("단어를 추가했습니다.");
		}else {
			System.out.println("뜻과 단어가 이미 등록된 상태입니다.");
		}
		
	}


		

	

}
