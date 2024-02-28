package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;

public interface BoardService {

	boolean insertBoard(BoardVO board);

	ArrayList<CommunityVO> getCommunityList();
	
	BoardVO getBoard(int num);

	int getTotalCount(Criteria cri);

	ArrayList<BoardVO> getBoardList(Criteria cri);

	//void를 boolean으로 수정.
	boolean updateView(int num);

	boolean deleteBoard(int num, MemberVO user);



	

}
