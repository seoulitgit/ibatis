package kr.co.seoulit.logistics.business.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.base.to.BOMBean;
import kr.co.seoulit.logistics.business.to.OrderBean;


public interface OrderDAO {
	List<OrderBean> searchOrderList(QueryBean query);

	void updateOrder(OrderBean orderBean);
	void deleteOrder(OrderBean orderBean);
	void insertOrder(OrderBean orderBean);
	}