package kr.kh.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.MemberDAO;

//서비스 어노테이션 까먹으면 500번 에러
@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;

	@Override
	public int getMemberCount() {
		return memberDao.selectMemberCount();
	}
}
