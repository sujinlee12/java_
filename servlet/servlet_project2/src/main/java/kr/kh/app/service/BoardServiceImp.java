package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.filter.Criteria;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;

public class BoardServiceImp implements BoardService {
	
	private BoardDAO boardDao;
	
	//생성자 이름은 클래스명과 동일
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
			} catch (IOException e) {
			e.printStackTrace();
			}
		
	}
	//서비스: 필수, 아닌지 널인지 아닌지 체크 / 없으면 다오에게 일 시키기
	@Override
	public ArrayList<BoardVO> getBoardList() {
		//Mapper에서 이름이 헷갈리지 않도록 이름을 설정하기
		return boardDao.selectBoardList();
	}
	@Override
	public boolean insertBoard(BoardVO board) {
		if( board == null || 
			!checkString(board.getBo_title()) ||
			!checkString(board.getBo_content())) {
			return false;
		}
		return boardDao.insertBoard(board);
	}
	
	//문자열이 null이거나 빈 문자열이면 false, 아니면 true를 반환하는 메서드
	public boolean checkString(String str) {
		if(str == null || str.length() == 0){
			return false;
		}
		return true;
		}
	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}
	@Override
	public boolean updateView(int num) {
		return boardDao.updateView(num);
		
	}
	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}
	@Override
	public boolean updateBoard(BoardVO board, MemberVO user) {
		
		//게시글 null 체크
		if(board == null || 
		  !checkString(board.getBo_title()) ||
		  !checkString(board.getBo_content())) {
		  return false;
			
		}
		
		//회원 null 체크
		if(user == null) {
			return false;
		}
		//게시글 번호를 이용하여 게시글을 가져옴
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		//게시글이 없거나 게시글 작성자가 회원이 아니면 false를 리턴
		if( dbBoard == null || 
		   !dbBoard.getBo_me_id().equals(user.getMe_id())) {
		   return false;
		}
		//서비스에게 게시글을 주면서 수정하라고 요청 
		return boardDao.updateBoard(board);
	
	}
	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectTotalCount(cri);
	}

}
