package kr.kh.spring3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring3.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		log.info("안녕하세요. 스프링 메인입니다.");
		//vo안만들고 간단하게 하는 방법
		int count = memberService.getMemberCount();
		log.info("등록된 회원 수 : " + count);
		return "home";
	}
	
}
