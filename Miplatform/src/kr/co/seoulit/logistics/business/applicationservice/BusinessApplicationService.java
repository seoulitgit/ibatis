package kr.co.seoulit.logistics.business.applicationservice;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.business.to.OrderBean;
import kr.co.seoulit.logistics.business.to.OrderInfoBean;


public interface BusinessApplicationService {
	
	List<OrderBean> searchOrderList(QueryBean query);
	void batchOrderProcess(List<OrderBean> orderList,List<OrderInfoBean> orderInfoList);
	}