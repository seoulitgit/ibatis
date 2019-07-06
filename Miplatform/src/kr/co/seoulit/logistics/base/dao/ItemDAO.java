package kr.co.seoulit.logistics.base.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.base.to.ItemBean;


public interface ItemDAO {
	List<ItemBean> getItemList();
	List<ItemBean> searchItemList(QueryBean query);
	void updateItem(ItemBean itemBean);
	void deleteItem(ItemBean itemBean);
	void insertItem(ItemBean itemBean);
	}