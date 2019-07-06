package kr.co.seoulit.logistics.purchase.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;
import kr.co.seoulit.logistics.purchase.to.MRPBean;
import kr.co.seoulit.logistics.purchase.to.ProductionPlanBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class ProductionPlanDAOImpl extends SqlMapClientDaoSupport implements ProductionPlanDAO {
	 
	
@Override
public List<ProductionPlanBean> searchMps(QueryBean query) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("ProductionPlan.searchMps",query);
}
@Override
	public List<MRPBean> unfoldMrp(QueryBean query) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("ProductionPlan.unfoldMrp",query);
	}
@Override
	public List<MRPBean> unfoldSumMrp(QueryBean query) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("ProductionPlan.unfoldSumMrp",query);
	}
@Override
	public void deleteproductionPlan(ProductionPlanBean productionPlanBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().delete("ProductionPlan.deleteproductionPlan", productionPlanBean);
	}
@Override
	public void insertproductionPlan(ProductionPlanBean productionPlanBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().insert("ProductionPlan.insertproductionPlan", productionPlanBean);
	}
@Override
	public void updateproductionPlan(ProductionPlanBean productionPlanBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().update("ProductionPlan.updateproductionPlan", productionPlanBean);
	}

}
