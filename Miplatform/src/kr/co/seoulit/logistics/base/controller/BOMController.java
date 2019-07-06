package kr.co.seoulit.logistics.base.controller;

import java.util.List;

import kr.co.seoulit.common.controller.AbstractMiplatformController;
import kr.co.seoulit.logistics.base.service.LogisticsBaseServiceFacade;
import kr.co.seoulit.logistics.base.to.BOMBean;
import kr.co.seoulit.logistics.base.to.WarehouseBean;

import com.tobesoft.platform.data.PlatformData;


public class BOMController extends AbstractMiplatformController {
	
	LogisticsBaseServiceFacade logisticsBaseServiceFacade;
	
	public void setLogisticsBaseServiceFacade(  
			LogisticsBaseServiceFacade logisticsBaseServiceFacade) {
		this.logisticsBaseServiceFacade = logisticsBaseServiceFacade;
	}

	public void searchBOM(PlatformData inData, PlatformData outData) throws Exception {
		String itemCode=inData.getVariable("item_code").getValue().getString();
		List<BOMBean> BOMList=logisticsBaseServiceFacade.searchBOM(itemCode);
		datasetBeanMapper.beansToDataset(outData, BOMList, BOMBean.class);
		
	}
	public void batchBOMProcess(PlatformData inData, PlatformData outData) throws Exception {
		List<BOMBean> bomList=datasetBeanMapper.datasetToBeans(inData, BOMBean.class);
		logisticsBaseServiceFacade.batchBOMProcess(bomList);
		
		
	}
	public void unfoldBOM(PlatformData inData, PlatformData outData) throws Exception {
		
		String parentItemCode=inData.getVariable("parentItemCode").getValue().getString();
		List<BOMBean> unfoldBOMList=logisticsBaseServiceFacade.unfoldBOM(parentItemCode);
		datasetBeanMapper.beansToDataset(outData, unfoldBOMList, BOMBean.class);
		
	}
	

}


