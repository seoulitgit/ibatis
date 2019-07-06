package kr.co.seoulit.logistics.base.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.base.to.ItemBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class ItemDAOImpl extends SqlMapClientDaoSupport implements ItemDAO {
	 
@Override
public void deleteItem(ItemBean itemBean) {
	// TODO Auto-generated method stub
	getSqlMapClientTemplate().delete("Item.deleteItem",itemBean);
}
@Override
	public List<ItemBean> getItemList() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Item.getItemList");
	}
@Override
	public void insertItem(ItemBean itemBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().insert("Item.insertItem",itemBean);
	}
@Override
	public void updateItem(ItemBean itemBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().update("Item.updateItem",itemBean);
	}
@Override 
	public List<ItemBean> searchItemList(QueryBean query){
	return getSqlMapClientTemplate().queryForList("Item.searchItemList", query);
}
}
