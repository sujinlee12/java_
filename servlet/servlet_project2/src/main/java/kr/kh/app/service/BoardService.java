package kr.kh.app.service;

import java.util.ArrayList;

import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;

public interface BoardService {

	

	boolean insertBoard(BoardVO board, ArrayList<Part> partList);

	ArrayList<CommunityVO> getCommunityList();

	
	boolean updateView(int num);
	
	BoardVO getBoard(int num);

	boolean updateBoard(BoardVO board, MemberVO user);


	boolean deleteBoard(int num, MemberVO user);

	int getTotalCount(Criteria cri);

	ArrayList<BoardVO> getBoardList(Criteria cri);

	ArrayList<FileVO> getFile(int num);

}
