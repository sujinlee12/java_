package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;

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

}
