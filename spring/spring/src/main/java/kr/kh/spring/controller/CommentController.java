package kr.kh.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.service.CommentService;

/*CommentController에 있는 모든 메서드들이(url을 이용하여 접근하는 메서드)
 * ajax로 통신하는 경우 @Controller + @ResponseBody 대신에
 * @RestController로 대체할 수 있다.
 * 그래서 @RestController에 있는 메서드들은 ajax로 통신한다(비동기 통신)
 * */


@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@ResponseBody
	@PostMapping("/comment/list")
	public Map<String, Object> commentList(@RequestBody Criteria cri){
		Map<String,Object> map = new HashMap<String,Object>();
		cri.setPerPageNum(3);
		//한 페이지에 댓글 3개씩 보여주도록
		ArrayList<CommentVO> commentList = commentService.getCommentList(cri);
		int totalCount = commentService.getTotalCount(cri);
		map.put("list", commentList);
		map.put("pm", pm);
		return map;	
	
	
	}
}
