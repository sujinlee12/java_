package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.LoginDTO;
import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);
	MemberVO getMember(LoginDTO loginDto);
	
	static MemberVO getMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

}
