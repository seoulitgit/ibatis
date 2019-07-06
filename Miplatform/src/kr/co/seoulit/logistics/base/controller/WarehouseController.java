package kr.co.seoulit.logistics.base.controller;

import java.util.List;

import kr.co.seoulit.common.controller.AbstractMiplatformController;
import kr.co.seoulit.logistics.base.service.LogisticsBaseServiceFacade;
import kr.co.seoulit.logistics.base.to.WarehouseBean;

import com.tobesoft.platform.data.PlatformData;


public class WarehouseController extends AbstractMiplatformController {
	
	LogisticsBaseServiceFacade logisticsBaseServiceFacade;
	
	public void setLogisticsBaseServiceFacade(  
			LogisticsBaseServiceFacade logisticsBaseServiceFacade) {
		this.logisticsBaseServiceFacade = logisticsBaseServiceFacade;
	}

	public void getWarehouseList(PlatformData inData, PlatformData outData) throws Exception {
		List<WarehouseBean> warehoustList=logisticsBaseServiceFacade.getWarehouseList();
		datasetBeanMapper.beansToDataset(outData, warehoustList, WarehouseBean.class);
		
	}
	public void batchWarehouseProcess(PlatformData inData, PlatformData outData) throws Exception {
		List<WarehouseBean> warehouseList=datasetBeanMapper.datasetToBeans(inData, WarehouseBean.class);
		logisticsBaseServiceFacade.batchWarehouseProcess(warehouseList);
		
		
	}
	
	

}


