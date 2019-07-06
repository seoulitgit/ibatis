package kr.co.seoulit.logistics.business.dao;

import java.util.List;

import kr.co.seoulit.logistics.base.to.BOMBean;
import kr.co.seoulit.logistics.business.to.OrderInfoBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class OrderInfoDAOImpl extends SqlMapClientDaoSupport implements OrderInfoDAO {
	 
@Override
public void deleteOrderInfo(OrderInfoBean orderInfoBean) {
	// TODO Auto-generated method stub
	getSqlMapClientTemplate().delete("Order.deleteOrderInfo", orderInfoBean);
}
@Override
	public void insertOrderInfo(OrderInfoBean orderInfoBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().insert("Order.insertOrderInfo", orderInfoBean);	
	}
@Override
	public void updateOrderInfo(OrderInfoBean orderInfoBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().update("Order.updateOrderInfo", orderInfoBean);	
	}

	
}
