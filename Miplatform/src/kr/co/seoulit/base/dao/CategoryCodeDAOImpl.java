package kr.co.seoulit.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.CategoryCodeBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class CategoryCodeDAOImpl extends SqlMapClientDaoSupport implements CategoryCodeDAO {

	@Override
	public List<CategoryCodeBean> findCodeCategoryList(){
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Code.findCodeCategoryList");

	}

}
