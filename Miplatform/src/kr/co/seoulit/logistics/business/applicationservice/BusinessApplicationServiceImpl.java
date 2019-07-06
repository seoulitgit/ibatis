package kr.co.seoulit.logistics.business.applicationservice;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.business.dao.OrderDAO;
import kr.co.seoulit.logistics.business.dao.OrderInfoDAO;
import kr.co.seoulit.logistics.business.to.OrderBean;
import kr.co.seoulit.logistics.business.to.OrderInfoBean;

import org.springframework.context.support.ResourceBundleMessageSource;



public class BusinessApplicationServiceImpl implements BusinessApplicationService {
	
	ResourceBundleMessageSource messageSource;
	OrderDAO orderDAO;
	OrderInfoDAO orderInfoDAO;
 	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public void setOrderInfoDAO(OrderInfoDAO orderInfoDAO) {
		this.orderInfoDAO = orderInfoDAO;
	}

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@Override
	public List<OrderBean> searchOrderList(QueryBean query) {
		// TODO Auto-generated method stub
		return orderDAO.searchOrderList(query);
	}
	@Override
  	public void batchOrderProcess(List<OrderBean> orderList,List<OrderInfoBean> orderInfoList) {
	// TODO Auto-generated method stub
		for(OrderBean orderBean:orderList){
		
			if(orderBean.getStatus().equals("insert")){
				orderDAO.insertOrder(orderBean);
			}else if(orderBean.getStatus().equals("update")){
				orderDAO.updateOrder(orderBean);
			}else{
				orderDAO.deleteOrder(orderBean);
			}
		}
		for(OrderInfoBean orderInfoBean:orderInfoList){
			if(orderInfoBean.getStatus().equals("insert")){
				orderInfoDAO.insertOrderInfo(orderInfoBean);
			}else if(orderInfoBean.getStatus().equals("update")){
				
				orderInfoDAO.updateOrderInfo(orderInfoBean);
			}else{
				orderInfoDAO.deleteOrderInfo(orderInfoBean);
			}
		}
	}
}
