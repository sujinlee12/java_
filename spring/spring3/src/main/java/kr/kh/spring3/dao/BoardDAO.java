package kr.kh.spring3.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.pagination.Criteria;

public interface BoardDAO {


	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectBoardTotalCount(@Param("cri") Criteria cri);

	boolean insertBoard(@Param("board") BoardVO board);

	ArrayList<CommunityVO> selectCategoryList(@Param("co") CommunityVO category);

	ArrayList<CommunityVO> selectCommunityList();

	void insertFile(@Param("file") FileVO fileVO);

	void updateView(@Param("num")int num); //지금은 param 안붙여도 되지만 헷갈릴 수 있으므로 붙임.

	BoardVO selectBoard(@Param("num")int num);

	ArrayList<FileVO> selectFileList(@Param("num") int num);
	
	//param을 안붙힐 때의 차이.. 매개변수 1개면 생략가능 여러개는 불가능
	//int나 스트링 같은 기본 자료형의 경우는 수정해도 메퍼에 수정할 필요 없음
	//Citeria , FileVO 등은 메퍼에 수정해줘야 함.
	//차이가 있으므로 일단 param을 다 붙히는게 나음.
	//메퍼에 bo_num으로 쓰고 싶으면 여기서도 "bo_num"으로 수정해야함

}
