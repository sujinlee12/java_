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
		boardService.updateView(num);
		BoardVO board = boardService.getBoard(num);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/boad/detail.jsp").forward(request, response);
	}

	

}
