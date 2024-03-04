package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.filter.Criteria;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;

public interface BoardService {

	

	boolean insertBoard(BoardVO board);

	ArrayList<CommunityVO> getCommunityList();

	int getTotalCount(Criteria cri);
	
	boolean updateView(int num);
	
	BoardVO getBoard(int num);


	boolean updateBoard(BoardVO board, MemberVO user);

	ArrayList<BoardVO> getBoardList(Criteria cri);


}
