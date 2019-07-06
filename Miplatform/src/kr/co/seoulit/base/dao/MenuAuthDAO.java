package kr.co.seoulit.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.MenuAuthorityBean;
import kr.co.seoulit.base.to.MenuBean;




public interface MenuAuthDAO {
	List<MenuBean> getMenuDataSet();
	List<MenuAuthorityBean> getMenuAuthority();
	void insertMenuAuth(MenuAuthorityBean menuAuthBean);
	void deleteMenuAuth(MenuAuthorityBean menuAuthBean);
	
	}
