package kr.kh.community.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Board {
	
	int bo_num;
	int bo_ca_num;
	Date bo_date;
	String bo_content;
	String bo_ca_name;
	String bo_ty_name;
	
	
	public Board(int boardNum, String date, String content, String type)throws ParseException{
		bo_ca_num = boardNum;
		bo_content = content;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		bo_date = format.parse(date);
		bo_ty_name = type;
		
	public //String getIt_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(bo_date);
	}
		
	}


	@Override
	public String toString() {
		return "Board [bo_num=" + bo_num + ", bo_ca_num=" + bo_ca_num + ", bo_date=" + bo_date + ", bo_content="
				+ bo_content + ", bo_ca_name=" + bo_ca_name + ", bo_ty_name=" + bo_ty_name + "]";
	}



}
