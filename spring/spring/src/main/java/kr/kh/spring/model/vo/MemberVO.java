package kr.kh.spring.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	
	private String me_id;
	private String me_pw;
	private String me_state;
	private String me_email;
	private String me_authority;
	private String me_stop;
	private int me_fail;
	private String me_cookie;
	private Date me_cookie_limit;
	private boolean autoLogin;
}
