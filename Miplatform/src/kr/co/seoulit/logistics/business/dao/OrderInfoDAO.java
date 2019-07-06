package kr.co.seoulit.logistics.business.dao;

import kr.co.seoulit.logistics.business.to.OrderInfoBean;


public interface OrderInfoDAO {
	
	void updateOrderInfo(OrderInfoBean orderInfoBean);
	void deleteOrderInfo(OrderInfoBean orderInfoBean);
	void insertOrderInfo(OrderInfoBean orderInfoBean);
	}