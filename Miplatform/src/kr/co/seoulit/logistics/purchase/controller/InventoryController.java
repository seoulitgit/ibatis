package kr.co.seoulit.logistics.purchase.controller;

import java.util.List;

import kr.co.seoulit.common.controller.AbstractMiplatformController;
import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.service.PurchaseServiceFacade;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;

import com.tobesoft.platform.data.PlatformData;


public class InventoryController extends AbstractMiplatformController {
	
	
	
	PurchaseServiceFacade purchaseServiceFacade;
	
	
	
	public void setPurchaseServiceFacade(PurchaseServiceFacade purchaseServiceFacade) {
		this.purchaseServiceFacade = purchaseServiceFacade;
	}



	public void searchInventory(PlatformData inData, PlatformData outData) throws Exception {
		QueryBean queryBean=datasetBeanMapper.datasetToBean(inData, QueryBean.class);
		List<InventoryBean> inventoryList=purchaseServiceFacade.searchInventory(queryBean);
		datasetBeanMapper.beansToDataset(outData, inventoryList, InventoryBean.class);
	}
	public void batchInventoryProcess(PlatformData inData, PlatformData outData) throws Exception {
		List<InventoryBean> inventoryList =datasetBeanMapper.datasetToBeans(inData, InventoryBean.class);
		purchaseServiceFacade.batchInventoryProcess(inventoryList);
	}
}


