package kr.kh.account.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;


public interface AccountDAO {

	List<Type> selectTypeList();

	List<Category> selectCategoryList(@Param("ty_name") String type);

	boolean insertItem(@Param("item")Item item);

	List<Item> selectItemListByDate(@Param("it_date")String date);

	boolean updateItem(@Param("item")Item item);

	boolean deletItem(@Param("It_num")int it_num);

}
//매개변수가 있는 경우 param을 다 붙이기

