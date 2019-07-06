package kr.co.seoulit.logistics.purchase.controller;

import java.util.List;

import kr.co.seoulit.common.controller.AbstractMiplatformController;
import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.service.PurchaseServiceFacade;
import kr.co.seoulit.logistics.purchase.to.MRPBean;
import kr.co.seoulit.logistics.purchase.to.ProductionPlanBean;

import com.tobesoft.platform.data.PlatformData;

public class MpsController extends AbstractMiplatformController {

	PurchaseServiceFacade purchaseServiceFacade;
	public void setPurchaseServiceFacade(PurchaseServiceFacade purchaseServiceFacade) {
		this.purchaseServiceFacade = purchaseServiceFacade;
	}
	

	public void searchMps(PlatformData inData, PlatformData outData)
			throws Exception {
		QueryBean queryBean = datasetBeanMapper.datasetToBean(inData,
				QueryBean.class);
		List<ProductionPlanBean> MpsList=purchaseServiceFacade.searchMps(queryBean);
		datasetBeanMapper.beansToDataset(outData, MpsList, ProductionPlanBean.class);
	}

	public void batchMpsProcess(PlatformData inData, PlatformData outData)
			throws Exception {
	
		List<ProductionPlanBean> orderList = datasetBeanMapper.datasetToBeans(inData,
				ProductionPlanBean.class);
		purchaseServiceFacade.batchMpsProcess(orderList);
	
	}

public void unfoldMrp(PlatformData inData, PlatformData outData)
		throws Exception {
	QueryBean queryBean = datasetBeanMapper.datasetToBean(inData,
			QueryBean.class);
	List<MRPBean> mrpList=purchaseServiceFacade.unfoldMrp(queryBean);
	datasetBeanMapper.beansToDataset(outData, mrpList, MRPBean.class);
}

public void unfoldSumMrp(PlatformData inData, PlatformData outData)
		throws Exception {
	QueryBean queryBean = datasetBeanMapper.datasetToBean(inData,
			QueryBean.class);
	List<MRPBean> mrpList=purchaseServiceFacade.unfoldSumMrp(queryBean);
	datasetBeanMapper.beansToDataset(outData, mrpList, MRPBean.class);
}
}
