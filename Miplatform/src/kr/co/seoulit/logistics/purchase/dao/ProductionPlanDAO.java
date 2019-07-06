package kr.co.seoulit.logistics.purchase.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;
import kr.co.seoulit.logistics.purchase.to.MRPBean;
import kr.co.seoulit.logistics.purchase.to.ProductionPlanBean;


public interface ProductionPlanDAO {
	List<ProductionPlanBean> searchMps(QueryBean query);
	List<MRPBean> unfoldMrp(QueryBean query);	
	List<MRPBean> unfoldSumMrp(QueryBean query);	
	
	void insertproductionPlan(ProductionPlanBean productionPlanBean);
	void updateproductionPlan(ProductionPlanBean productionPlanBean);
	void deleteproductionPlan(ProductionPlanBean productionPlanBean);
}