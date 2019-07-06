package kr.co.seoulit.logistics.purchase.service;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.applicationservice.PurchaseApplicationService;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;
import kr.co.seoulit.logistics.purchase.to.MRPBean;
import kr.co.seoulit.logistics.purchase.to.ProductionPlanBean;
import kr.co.seoulit.logistics.purchase.to.SubulRecordBean;


public class PurchaseServiceFacadeImpl implements PurchaseServiceFacade {
	PurchaseApplicationService purchaseApplicationService;

	public PurchaseApplicationService getPurchaseApplicationService() {
		return purchaseApplicationService;
	}

	public void setPurchaseApplicationService(
			PurchaseApplicationService purchaseApplicationService) {
		this.purchaseApplicationService = purchaseApplicationService;
	}
	@Override
	public List<InventoryBean> searchInventory(QueryBean queryBean){
		return purchaseApplicationService.searchInventory(queryBean);
	}@Override
	public List<SubulRecordBean> searchSubul(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return purchaseApplicationService.searchSubul(queryBean);
	}
	@Override
	public List<ProductionPlanBean> searchMps(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return purchaseApplicationService.searchMps(queryBean);
	}
	@Override
	public List<MRPBean> unfoldMrp(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return purchaseApplicationService.unfoldMrp(queryBean);
	}
	@Override
	public List<MRPBean> unfoldSumMrp(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return purchaseApplicationService.unfoldSumMrp(queryBean);
	}
	@Override
	public void batchInventoryProcess(List<InventoryBean> InventoryList) {
		// TODO Auto-generated method stub
		purchaseApplicationService.batchInventoryProcess(InventoryList);
	}
	@Override
	public void batchSubulProcess(List<SubulRecordBean> subulList) {
		// TODO Auto-generated method stub
		purchaseApplicationService.batchSubulProcess(subulList);
	}
	@Override
	public void batchMpsProcess(List<ProductionPlanBean> ProductionPlanList) {
		// TODO Auto-generated method stub
		purchaseApplicationService.batchMpsProcess(ProductionPlanList);
	}
}

