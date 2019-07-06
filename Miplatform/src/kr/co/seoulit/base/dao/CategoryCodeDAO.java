package kr.co.seoulit.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.CategoryCodeBean;




public interface CategoryCodeDAO {
	List<CategoryCodeBean> findCodeCategoryList();
	
	}
