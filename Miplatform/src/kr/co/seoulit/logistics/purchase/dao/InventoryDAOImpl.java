package kr.co.seoulit.logistics.purchase.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class InventoryDAOImpl extends SqlMapClientDaoSupport implements InventoryDAO {
	 
	
@Override
public List<InventoryBean> searchInventory(QueryBean query) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("Inventory.searchInventory",query);
}

@Override
	public void updateInventory(InventoryBean inventoryBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().update("Inventory.updateInventory", inventoryBean);
}
}
