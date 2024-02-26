package kr.kh.app.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//아이디와 비번을 매개로 하는 생성자를 만듬.
public class LoginDTO {
	private String id;
	private String pw;

}
