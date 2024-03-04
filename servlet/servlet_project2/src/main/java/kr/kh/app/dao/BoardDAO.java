package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;

public interface BoardDAO {

	

	ArrayList<BoardVO> selectBoardList();

	boolean insertBoard(@Param("board")BoardVO board);
	//메퍼에는 파람에 있는 이름 쓰기.


	//insertBoard
	ArrayList<CommunityVO> selectCommunityList();

	//int selectTotal
	boolean  updateView(@Param("num")int num);

	BoardVO selectBoard(@Param("num")int num);
	//delete

	boolean updateBoard(@Param("board")BoardVO board);

	

	
	

}
