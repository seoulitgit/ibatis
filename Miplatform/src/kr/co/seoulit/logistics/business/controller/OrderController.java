package kr.co.seoulit.logistics.business.controller;

import java.util.ArrayList;
import java.util.List;

import com.tobesoft.platform.data.PlatformData;

import kr.co.seoulit.common.controller.AbstractMiplatformController;
import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.business.service.BusinessServiceFacade;
import kr.co.seoulit.logistics.business.to.OrderBean;
import kr.co.seoulit.logistics.business.to.OrderInfoBean;
import kr.co.seoulit.logistics.purchase.to.SubulRecordBean;

public class OrderController extends AbstractMiplatformController {

	BusinessServiceFacade businessServiceFacade;

	public void setBusinessServiceFacade(
			BusinessServiceFacade businessServiceFacade) {
		this.businessServiceFacade = businessServiceFacade;
	}

	public void searchOrderList(PlatformData inData, PlatformData outData)
			throws Exception {
		QueryBean queryBean = datasetBeanMapper.datasetToBean(inData,
				QueryBean.class);

		List<OrderBean> orderList = businessServiceFacade
				.searchOrderList(queryBean);
		List<OrderInfoBean> orderInfoList = new ArrayList<OrderInfoBean>();
		for (OrderBean orderBean : orderList) {
			for (OrderInfoBean orderInfoBean : orderBean.getOrderInfoList()) {
				orderInfoList.add(orderInfoBean);
			}
		}

		datasetBeanMapper.beansToDataset(outData, orderList, OrderBean.class);
		datasetBeanMapper.beansToDataset(outData, orderInfoList,
				OrderInfoBean.class);
	}

	public void batchOrderProcess(PlatformData inData, PlatformData outData)
			throws Exception {
	
		List<OrderBean> orderList = datasetBeanMapper.datasetToBeans(inData,
				OrderBean.class);
		List<OrderInfoBean> orderinfoList = datasetBeanMapper.datasetToBeans(
				inData, OrderInfoBean.class);

		
		businessServiceFacade.batchOrderProcess(orderList,orderinfoList);
	}

}
