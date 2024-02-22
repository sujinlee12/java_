package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MainServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String data = request.getParameter("data");
		System.out.println("전송 받은 데이터 : " + data);
		String id = request.getParameter("id");
		System.out.println("전송 받은 id : " + id);
		
		//화면으로 나이를 전송
		int age =30;
		request.setAttribute("age", age);
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
		String login = request.getParameter("login");
		System.out.println("로그인 : "+ login);
		
	
	}

}
