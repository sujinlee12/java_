package kr.kh.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.MemberDAO;
import kr.kh.spring3.model.vo.MemberVO;

//서비스 어노테이션 까먹으면 500번 에러
@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public int getMemberCount() {
		return memberDao.selectMemberCount();
	}

	@Override
	public String signupMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null) 
			return false;
		//아이디 중복 확인
		//아이디와 일치하는 회원 정보 요청
		MemberVO user = memberDao.selectMember(member.getMe_id());
		//이미 가입된 아이디
		if(user != null)
			return false;
		//빈 문자열도 암호화를 적용하면 빈문자열이 아니기 때문에 가입이 될 수 있어서 처리 
		if(member.getMe_pw() == null || member.getMe_pw().length() == 0) {
			return false;
		}
		//비밀번호 암호화
		String encodePw = passwordEncoder.encode(member.getMe_pw());
		//암호화된 비번을 member객체에 업데이트
		member.setMe_pw(encodePw);
		try {
			return memberDao.insertMember(member);
		}catch(Exception e) {
			//이메일이 없으면 예외 발생
			e.printStackTrace();
			return false;
			
		}
	}

	

	
}
