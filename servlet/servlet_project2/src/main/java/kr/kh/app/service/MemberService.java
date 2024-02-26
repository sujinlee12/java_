package kr.kh.app.service;

import kr.kh.app.model.vo.MemberVO;

public interface MemberService {
	//update, insert랑 또 뭐 (?) boolean으로 일을 시키면 된다.
	boolean signup(MemberVO member);

}
