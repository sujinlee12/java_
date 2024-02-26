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
	//	String resource = "kr/kh/app/mybatis-config.xml";
	InputStream inputStream;
	SqlSession session;
	try {
		inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sessionFactory.openSession(true);
		boardDao = session.getMapper(MemberDAO.class);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
	boolean signup(MemberVO member);
	MemberVO getMember(LoginDTO loginDto);

}
