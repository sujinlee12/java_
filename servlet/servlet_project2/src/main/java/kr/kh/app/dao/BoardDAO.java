package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;

public interface BoardDAO {

	
	
	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	boolean insertBoard(@Param("board")BoardVO board);

	ArrayList<CommunityVO> selectCommunityList();

	int selectTotalCount(@Param("cri")Criteria cri);
	
	boolean  updateView(@Param("num")int num);

	BoardVO selectBoard(@Param("num")int num);
	
	boolean deleteBoard(@Param("num")int num);
	
	boolean updateBoard(@Param("board")BoardVO board);

	void insertFile(@Param("file")FileVO fileVo);
	
	ArrayList<FileVO> selectFileList(@Param("bo_num")int num); //의미를 명확하게 전달하기 위해 file => bo_num으로 변경.

	void deleteFile(@Param("fi_num")int fi_num);

	FileVO selectFile(@Param("fi_num")int num); //기본키를 넘겨줌

	//RecommendVO selectRecommend(@Param("me_id") String me_id, @Param("bo_num")int bo_num);

	RecommendVO selectRecommend(@Param("me_id")String me_id, @Param("bo_num") int num);
	
	void insertRecommend(@Param("re") RecommendVO recommend);

	void updateRecommend(@Param("re") RecommendVO recommend);

	ArrayList<CommentVO> selectCommentList(@Param("cri")Criteria cri);

	

	
	





	

	
	

}
