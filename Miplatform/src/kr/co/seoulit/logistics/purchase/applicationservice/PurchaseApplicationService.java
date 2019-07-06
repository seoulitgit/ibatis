package kr.co.seoulit.logistics.purchase.applicationservice;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;
import kr.co.seoulit.logistics.purchase.to.MRPBean;
import kr.co.seoulit.logistics.purchase.to.ProductionPlanBean;
import kr.co.seoulit.logistics.purchase.to.SubulRecordBean;


public interface PurchaseApplicationService {
	List<InventoryBean> searchInventory(QueryBean queryBean);
	List<SubulRecordBean> searchSubul(QueryBean queryBean);
	List<ProductionPlanBean> searchMps(QueryBean queryBean);
	List<MRPBean> unfoldMrp(QueryBean queryBean);
	List<MRPBean> unfoldSumMrp(QueryBean queryBean);
	
	void batchInventoryProcess(List<InventoryBean> InventoryList);
	void batchSubulProcess(List<SubulRecordBean> subulList);
	void batchMpsProcess(List<ProductionPlanBean> ProductionPlanList);
	}