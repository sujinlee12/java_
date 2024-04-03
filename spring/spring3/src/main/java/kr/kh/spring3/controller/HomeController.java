package kr.kh.spring3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		log.info("안녕하세요. 스프링 메인입니다.");
		//vo안만들고 간단하게 하는 방법
		int count = memberService.getMemberCount();
		//log.info("등록된 회원 수 : " + count);
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "회원가입");
		return "/member/signup";
		
	}
	
	@PostMapping("/signup")
	public String signupPost (Model model, MemberVO member) {
	  boolean res = memberService.signup(member);
		if(res) {
			model.addAttribute("msg", "회원가입을 했습니다.");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "회원가입을 하지 못했습니다.");
			model.addAttribute("url", "/signup");
		}
		return "message";
	}
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "로그인");
		return "/member/login";
		
	}
	//매개변수를 기본생성자로 객체를 만들어서 일단 넘긴다.
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		log.info(member);
		//log.info(member); //로그인한 회원 정보를 가져오는지 확인하고 다음 작업 
		MemberVO user = memberService.login(member);
		//log.info(user);//시킨 일을 다시 확인하기.
		model.addAttribute("user",user);//user라는 이름으로 전송, 인터셉터의 이름과 맞춤
		if(user != null){
			model.addAttribute("url", "/");
			model.addAttribute("msg", "로그인에 성공했습니다.");
		}else {
			model.addAttribute("url", "/login");
			model.addAttribute("msg", "로그인에 실패했습니다.");
		}
		return "message";
	}
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("user");
		model.addAttribute("msg","로그아웃 했습니다.");
		model.addAttribute("url","/");
		return "message";
			
	}
}
