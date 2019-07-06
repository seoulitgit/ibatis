package kr.co.seoulit.logistics.business.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.base.to.BOMBean;
import kr.co.seoulit.logistics.business.to.OrderBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class OrderDAOImpl extends SqlMapClientDaoSupport implements OrderDAO {
	 
@Override
public List<OrderBean> searchOrderList(QueryBean query) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("Order.searchOrderList", query);
}
	@Override
		public void deleteOrder(OrderBean orderBean) {
			// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("Order.deleteOrder", orderBean);
		}
	@Override
		public void insertOrder(OrderBean orderBean) {
				// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Order.insertOrder", orderBean);		
			}
	@Override
		public void updateOrder(OrderBean orderBean) {
					// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("Order.updateOrder", orderBean);			
				}
	
}
