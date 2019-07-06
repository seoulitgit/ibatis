package kr.co.seoulit.logistics.purchase.service;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;
import kr.co.seoulit.logistics.purchase.to.MRPBean;
import kr.co.seoulit.logistics.purchase.to.ProductionPlanBean;
import kr.co.seoulit.logistics.purchase.to.SubulRecordBean;


public interface PurchaseServiceFacade {
	List<InventoryBean> searchInventory(QueryBean queryBean);
	List<SubulRecordBean> searchSubul(QueryBean queryBean);
	List<ProductionPlanBean> searchMps(QueryBean queryBean);
	List<MRPBean> unfoldMrp(QueryBean queryBean);
	List<MRPBean> unfoldSumMrp(QueryBean queryBean);
	void batchSubulProcess(List<SubulRecordBean> subulList);
	void batchInventoryProcess(List<InventoryBean> InventoryList);
	void batchMpsProcess(List<ProductionPlanBean> ProductionPlanList); 
	}