package kr.kh.app.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.utils.FileUploadUtils;

public class BoardServiceImp implements BoardService {
	private BoardDAO boardDao;
	private String uploadPath = "D:\\uploads";
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";

		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	
	public boolean insertBoard(BoardVO board, ArrayList<Part> partList) {
		if (board == null || 
			!checkString(board.getBo_content()) ||
			!checkString(board.getBo_title())) {
			return false;
		}
		if (!checkString(board.getBo_me_id())){
			
			return false;
		}

		boolean res = boardDao.insertBoard(board);
		
		if(!res) {
			return false;
		}
		
		//첨부파일 업로드
		for(Part filePart : partList) {
			uploadFile(filePart,board.getBo_num());
		}
		return res;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {

		return boardDao.selectCommunityList();
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if (cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectTotalCount(cri);
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {

		if (cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);

	}

	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}
	
	//매개변수는 객체인 경우 체크를 함
	@Override
	public boolean updateView(int num) {
		return boardDao.updateView(num);
	}

	@Override
	public boolean deleteBoard(int num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//다오에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardDao.selectBoard(num);
		//게시글 작성자와 회원 아이디가 다르면 false 반환
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())){
			return false;
		}
		
		//게시글의 첨부파일을 서버 폴더에서 삭제(실제 파일)
		//게시글의 첨부파일을 DB에서 삭제
		//게시글에 있는 첨부파일 정보를 가져옴
	
		ArrayList<FileVO> fileList = boardDao.selectFileByBo_num(num);
		
		for(FileVO file : fileList) {
			deleteFile(file);	
		}
		
		//같으면 게시글 삭제 후 삭제 여부를 반환
		return boardDao.deleteBoard(num);
	}


	@Override
	public boolean updateBoard(BoardVO board, MemberVO user, ArrayList<Integer> nums, ArrayList<Part> fileList) {
		if(user == null|| user.getMe_id() == null) {
			return false;
		}
		if(	board == null || 
			!checkString(board.getBo_content())||
			!checkString(board.getBo_title())) {
			return false;
		}
		//게시글 번호를 이용하여 게시글을 가져옴
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		//게시글 작성자와 회원 아이디를 비교하여 다르면 false 반환
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		
		//첨부파일 추가
		for(Part file : fileList) {
			uploadFile(file,board.getBo_num());
		}
		//첨부파일 삭제
		for(int fi_num : nums) {
			FileVO fileVo = boardDao.selectFile(fi_num);
			deleteFile(fileVo);
	
		}
	
		
		//파일을 가져와서 수정 selectFile
		
		//같으면 게시글 수정
		return boardDao.updateBoard(board);
	}
	
	@Override
	public int recommend(int bo_num, int state, MemberVO user) {
		if(user == null) {
			throw new RuntimeException();
		}
		//게시글 번호와 아이디를 주면서 추천 정보를 가져오라고 시킴
		RecommendVO recommend = boardDao.selectRecommend(user.getMe_id(),bo_num);
		//없으면 추가
		if(recommend == null) {
			recommend = new RecommendVO(user.getMe_id(),bo_num,state);
			boardDao.insertRecommend(recommend);
			return state;
		}
		//있으면 수정 
		else {
			//기존 추천 상태와 state가 같으면 취소(0으로 변경)
			if(state == recommend.getRe_state()) {
				recommend.setRe_state(0);
			}
			//다르면 state로 변경
			else {
				recommend.setRe_state(state);
			
			} 
			boardDao.updateRecommend(recommend);
			return recommend.getRe_state();	
			
		}
	}
		//return 0;
	
	
	//checkString은 내부에서만 쓰려고 만드는거라 private으로 해도 상관없음
	private boolean checkString(String str) {
		if(str == null || str.length() == 0) {
		return false;
		}
		return true;
	}
	private void uploadFile(Part filePart, int bo_num) {
		//업로드할 첨부 파일이 없으면
		if(filePart == null) {
			return;
		}
		String fileOriName = FileUploadUtils.getFileName(filePart);
		if (fileOriName == null || fileOriName.length() ==0) {
			return;
		}
		String fileName = FileUploadUtils.upload(uploadPath, filePart);
		FileVO file = new FileVO(bo_num, fileName, fileOriName);
		boardDao.insertFile(file);
		
	}

	private void deleteFile(FileVO fileVo) {
		if(fileVo == null) {
			return;
		}
		File file = new File(uploadPath 
				+ fileVo.getFi_name().replace('/',File.separatorChar));
		//Fi_name() = 실제 서버의 경로를 이용해서 찾고 / 로 저장했기때문에 \로 바꾸려면 file.sepator 필요
		if(file.exists()) {
			file.delete();
			//해당 파일이 존재하면 삭제를 함.
		}	
		boardDao.deleteFile(fileVo.getFi_num());
		//첨부파일 최대 3개로 바꿀 것이기 때문에 게시글 번호로 지우는 것은 어려움. 
	}
	
	@Override
	public ArrayList<FileVO> getFile(int num) {
		return boardDao.selectFileByBo_num(num);
	}

	@Override
	public RecommendVO getRecommend(MemberVO user, int num) {
		if(user == null) {
			return null;
		}
		//이미 만들어져서 호출만 해주면 된다.
		return boardDao.selectRecommend(user.getMe_id(), num);
	}

	@Override
	public boolean insertComment(CommentVO comment) {
		if(	comment == null ||
			!checkString(comment.getCm_content())) {
			return false;
		}
		return boardDao.insertComment(comment);
	}

	@Override
	public ArrayList<CommentVO> getCommunityList(Criteria cri) {
		if( cri == null) {
			cri = new Criteria(1,2);
		}
		return boardDao.selectCommentList(cri);
	}

	@Override
	public int getTotalCountComment(CommentCriteria cri) {
		if(cri == null) {
			return 0;
		}
		return boardDao.selectTotalCountComment(cri);
	}

	@Override
	public boolean deleteComment(int num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//댓글 번호와 일치하는 댓글을 가져옴
		CommentVO comment = boardDao.selectComment(num);
		//댓글 작성자가 회원인지 확인하여 아니면 false 리턴
		if(comment == null || !comment.getCm_me_id().equals(user.getMe_id())) {
			return false;
		}
		//맞으면 삭제 요청
		
		return boardDao.deleteComment(num);
	}

	@Override
	public boolean updateComment(CommentVO comment) {
		if(comment == null || 
			!checkString(comment.getCm_content()) ||
			!checkString(comment.getCm_me_id())) {
			return false;
		}
		
		CommentVO dbComment = boardDao.selectComment(comment.getCm_num());
		if(	dbComment == null || 
			!dbComment.getCm_me_id().equals(comment.getCm_me_id())) {
			return false;
		}
		
		return boardDao.updateComment(comment);
		
	}

}
	