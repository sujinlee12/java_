package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

//criteria에 필요한 속성이 다를 때 사용 가능

@Data
@NoArgsConstructor
public class CommentCriteria extends Criteria {
	
	private int boNum;

	public CommentCriteria(int page, int perPageNum, int boNum) {
		super(page, perPageNum);
		this.boNum = boNum;
		
	}

}
