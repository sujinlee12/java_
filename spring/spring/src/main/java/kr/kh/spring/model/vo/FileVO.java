package kr.kh.spring.model.vo;

//class이름이 매번 달라지기 때문에 문서
public class FileVO {
	private int fi_num;  
	private int fi_bo_num; 
	private String fi_name;  
	private String fi_ori_name;
	
	public FileVO(int fi_bo_num, String fi_name, String fi_ori_name) {
		this.fi_bo_num = fi_bo_num;
		this.fi_name = fi_name;
		this.fi_ori_name = fi_ori_name;
	}
}
