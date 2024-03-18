package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;


public class GuestInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
		    throws Exception {
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//로그인 했으면
		if(user != null) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		return true;
			
	}
	
}
