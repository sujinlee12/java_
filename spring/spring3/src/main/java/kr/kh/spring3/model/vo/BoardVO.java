package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BoardVO {
	int bo_num;
	String bo_me_id; 
	int bo_co_num;
	String bo_title; 
	String bo_content; 
	int bo_view; 
	int bo_report_count;
}
