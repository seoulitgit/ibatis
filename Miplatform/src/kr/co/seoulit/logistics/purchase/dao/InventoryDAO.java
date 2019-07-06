package kr.co.seoulit.logistics.purchase.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;


public interface InventoryDAO {
	List<InventoryBean> searchInventory(QueryBean query);
	void updateInventory(InventoryBean inventoryBean);
}