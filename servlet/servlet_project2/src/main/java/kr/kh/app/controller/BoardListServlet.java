package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		private BoardService boardService = new BoardServiceImp();
		
		//서비스에게 게시글을 리스트를 달라고 요청
		request.setAttribute("board", board);
		//화면에 게시글 리스트를 전송 
		request.setAttribute(getServletName(), response);
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
		
	}
}
