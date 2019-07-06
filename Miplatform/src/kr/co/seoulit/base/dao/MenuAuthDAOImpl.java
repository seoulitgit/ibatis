package kr.co.seoulit.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.MenuAuthorityBean;
import kr.co.seoulit.base.to.MenuBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class MenuAuthDAOImpl extends SqlMapClientDaoSupport implements MenuAuthDAO {

@Override
public List<MenuBean> getMenuDataSet() {
// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("MenuAuth.getMenuDataSet");
}
@Override
public List<MenuAuthorityBean> getMenuAuthority() {
// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("MenuAuth.getMenuAuthority");
			}
@Override
	public void deleteMenuAuth(MenuAuthorityBean menuAuthBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().delete("MenuAuth.deleteMenuAuth",menuAuthBean);
	}
@Override
	public void insertMenuAuth(MenuAuthorityBean menuAuthBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().insert("MenuAuth.insertMenuAuth",menuAuthBean);
	}

}
