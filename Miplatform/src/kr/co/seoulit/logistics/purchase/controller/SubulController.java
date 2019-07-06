package kr.co.seoulit.logistics.purchase.controller;

import java.util.List;

import kr.co.seoulit.common.controller.AbstractMiplatformController;
import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.service.PurchaseServiceFacade;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;
import kr.co.seoulit.logistics.purchase.to.SubulRecordBean;

import com.tobesoft.platform.data.PlatformData;


public class SubulController extends AbstractMiplatformController {
	
	
	
	PurchaseServiceFacade purchaseServiceFacade;
	
	
	
	public void setPurchaseServiceFacade(PurchaseServiceFacade purchaseServiceFacade) {
		this.purchaseServiceFacade = purchaseServiceFacade;
	}



	public void searchSubul(PlatformData inData, PlatformData outData) throws Exception {
		QueryBean queryBean=datasetBeanMapper.datasetToBean(inData, QueryBean.class);
		List<SubulRecordBean> subulList=purchaseServiceFacade.searchSubul(queryBean);
		datasetBeanMapper.beansToDataset(outData, subulList, SubulRecordBean.class);
	}
	public void batchSubulProcess(PlatformData inData, PlatformData outData) throws Exception {
		List<SubulRecordBean> subulList =datasetBeanMapper.datasetToBeans(inData, SubulRecordBean.class);
		purchaseServiceFacade.batchSubulProcess(subulList);
	}
}


