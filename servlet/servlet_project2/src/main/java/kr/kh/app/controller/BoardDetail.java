package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;


@WebServlet("/board/detail")
public class BoardDetail extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    private BoardService boardService = new BoardServiceImp();   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e ) {
			num = 0;
		}
		//서비스에게 게시글 번호가 num인 게시글의 조회수를 증가하라고 시킴
		boardService.updateView(num);
		//서비스에게 게시글 번호가 num인 게시글을 가져오라고 요청
		BoardVO board = boardService.getBoard(num);
		//화면에 게시글을 전송
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/boad/detail.jsp").forward(request, response);
	
		}


	}
