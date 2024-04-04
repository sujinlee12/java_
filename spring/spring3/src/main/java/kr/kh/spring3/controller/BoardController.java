package kr.kh.spring3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/post/list")
	public String postList(Model model,Criteria cri) {
		//cri.setPage(2); //보여줄 페이지
		ArrayList<BoardVO>list = boardService.getBoardList(cri);
		int totalCount = boardService.getBoardTotalCount(cri);
		PageMaker pm = new PageMaker(3,cri,totalCount);
		model.addAttribute("pm", pm);
		model.addAttribute("title", "게시글 목록");
		model.addAttribute("list", list);
		return "/post/list"; //앞에 슬러시 안하면 헤더와 푸터가 사라짐.
		
	}
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		model.addAttribute("title", "게시글 추가");
		return "/post/insert"; //앞에 슬러시 안하면 헤더와 푸터가 사라짐.
		
	}
	@PostMapping("/post/insert")
	public String postInsertPost(Model model,BoardVO board,
			HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.insertBoard(board,user);
		if(res) {
			model.addAttribute("msg","게시글을 등록했습니다.");
			model.addAttribute("url","/post/list");			
		}else {
			model.addAttribute("msg","게시글을 등록하지 못했습니다.");
			model.addAttribute("url","/post/insert");		
		}	
		return "message"; //앞에 슬러시 안하면 헤더와 푸터가 사라짐.
		
	}

}
