package kr.co.seoulit.logistics.business.service;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.business.applicationservice.BusinessApplicationService;
import kr.co.seoulit.logistics.business.to.OrderBean;
import kr.co.seoulit.logistics.business.to.OrderInfoBean;


public class BusinessServiceFacadeImpl implements BusinessServiceFacade {
	
	BusinessApplicationService businessApplicationService;

	public void setBusinessApplicationService(
			BusinessApplicationService businessApplicationService) {
		this.businessApplicationService = businessApplicationService;
	}
	
	@Override
	public List<OrderBean> searchOrderList(QueryBean query) {
		// TODO Auto-generated method stub
		return businessApplicationService.searchOrderList(query);
	}
	@Override
	public void batchOrderProcess(List<OrderBean> orderList,List<OrderInfoBean> orderInfoList) {
		// TODO Auto-generated method stub
		businessApplicationService.batchOrderProcess(orderList,orderInfoList);
	}
}

