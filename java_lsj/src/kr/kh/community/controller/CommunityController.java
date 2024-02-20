package kr.kh.community.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat.Type;

import kr.kh.community.model.Board;
import kr.kh.community.service.CommunityService;
import kr.kh.community.service.CommunityServiceImp;


public class CommunityController {

	private Scanner scan;
	private CommunityService communityService;
	
	public CommunityController(Scanner scan) {
		if ( scan == null ) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		communityService = new CommunityServiceImp();
	
	}

	public void run() {
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
			}while(menu !=5);
		
	}
	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("-----------");
		System.out.println("1. 게시글 입력 ");
		System.out.println("2. 게시글 수정 ");
		System.out.println("3. 게시글 삭제 ");
		System.out.println("4. 게시글 조회 ");
		System.out.println("5. 이전 ");
		System.out.println("----------- ");
		System.out.println("메뉴 선택 : ");
	}

	
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
		case 3:
			delete();
			break;
		case 4:
			view();
			break;
		case 5:
			System.out.println("이전으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
			
		}
		
	}

	
	//조회메서드
	private void view() {
		System.out.println("조회할 게시글의 날짜를 입력하세요(yyyy-MM-dd 또는 yyyy-MM 또는 yyyy) : ");
		String date = scan.next();
		List<Board>BoardList = communityService.getBoard.ListByDate(date);
		if(BoardList == null || BoardList.size() == 0) {
			System.out.println("조회할 내역이 없습니다.");
			return;
		}
		for(Board tmp : BoardList) {
			System.out.println(tmp);
		}
	
	}

	//삭제메서드
	private void delete() {
		System.out.println("삭제할 게시글의 날짜를 입력하세요(yyyy-MM-dd) : ");
		String date = scan.next();
		List<Board> BoardList = BoardService.getItemListByDate(board);
		if(BoardList == null || BoardList.size() == 0) {
			System.out.println("삭제할 내역이 없습니다.");
			return;
			
	}

	//수정메서드
	private void update() {
		System.out.println("날짜를 입력하세요 (yyyy-MM-dd) : ");
		String date = scan.next();
		List<board> boardList = communityService.getBoardListByDate(date);
		if(boardList == null boardList.size()==0) {
			System.out.println("수정할 내역이 없습니다.");
			return;
		}
		//수정할 내역이 있으면 수정 가능한 내역을 출력
		for(Board board : boardList) {
			System.out.println(board);
		}
		System.out.println("내역 번호를 선택하세요 : ");
		int bo_num = scan.nextInt();
		
		//입력한 내역 번호가 잘못된 값인지 확인
		if(!boardList.contains(new Boar (bo_num))) {
			System.out.println("잘못된 내역 번호입니다.");
			return;
		}
		try {
			Board board = inputBoard();
			board.set bo_num(bo_num)){
				System.out.println("내역 수정이 완료되었습니다.");
			}else {
				System.out.println("내역을 수정하지 못했습니다.");
				
			}
		}catch(ParseException e) {
			System.out.println("날짜를 잘못 입력하여 내역을 수정하지 못했습니다.");
			return;
		}
	}
	//추가 메서드
	private Board inputBoard() throws ParseException{
		List<Type>typeList = communityService.getTypeList();
		
		for(int i=0; i<typeList.size(); i++) {
			System.out.println(typeList.get(i).getTy_name());
			if(i != typeList.size() -1) {
				System.out.println("/");
			}
		}
		System.out.println("중 하나를 입력하세요");
		String type = scan.next();
		
	}



	private void insert() {
		
		try {
			Board board = inputBoard();
			if(communityService.insertBoard(board)) {
				System.out.println("내역을 추가했습니다.");
				
			}else {
				System.out.println("내역을 추가하지 못했습니다.");
			}
		}catch(ParseException e) {
			System.out.println("날짜 형식이 잘못됐습니다.");
		}
	
	}






	
}
