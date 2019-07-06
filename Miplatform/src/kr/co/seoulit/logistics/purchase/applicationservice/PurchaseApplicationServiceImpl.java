package kr.co.seoulit.logistics.purchase.applicationservice;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.business.applicationservice.BusinessApplicationService;
import kr.co.seoulit.logistics.business.dao.OrderInfoDAO;
import kr.co.seoulit.logistics.business.to.OrderInfoBean;
import kr.co.seoulit.logistics.purchase.dao.InventoryDAO;
import kr.co.seoulit.logistics.purchase.dao.ProductionPlanDAO;
import kr.co.seoulit.logistics.purchase.dao.SubulRecordDAO;
import kr.co.seoulit.logistics.purchase.exception.NoDataFoundException;
import kr.co.seoulit.logistics.purchase.exception.NotEnoughStockException;
import kr.co.seoulit.logistics.purchase.exception.OverflowStockException;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;
import kr.co.seoulit.logistics.purchase.to.MRPBean;
import kr.co.seoulit.logistics.purchase.to.ProductionPlanBean;
import kr.co.seoulit.logistics.purchase.to.SubulRecordBean;

import org.springframework.context.support.ResourceBundleMessageSource;



public class PurchaseApplicationServiceImpl implements PurchaseApplicationService {

	ResourceBundleMessageSource messageSource;
	
	OrderInfoDAO orderInfoDAO; 
	InventoryDAO inventoryDAO;
	SubulRecordDAO subulRecordDAO;
	ProductionPlanDAO productionPlanDAO;
	
	
	public void setOrderInfoDAO(OrderInfoDAO orderInfoDAO) {
		this.orderInfoDAO = orderInfoDAO;
	}
	public void setProductionPlanDAO(ProductionPlanDAO productionPlanDAO) {
		this.productionPlanDAO = productionPlanDAO;
	}
	public void setSubulRecordDAO(SubulRecordDAO subulRecordDAO) {
		this.subulRecordDAO = subulRecordDAO;
	}
	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public List<InventoryBean> searchInventory(QueryBean queryBean){
		return inventoryDAO.searchInventory(queryBean);
	}
	@Override
	public List<SubulRecordBean> searchSubul(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return subulRecordDAO.searchSubul(queryBean);
	}
	@Override
	public List<MRPBean> unfoldMrp(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return productionPlanDAO.unfoldMrp(queryBean);
	}
	@Override
	public List<MRPBean> unfoldSumMrp(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return productionPlanDAO.unfoldSumMrp(queryBean);
	}
	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}
	@Override
	public List<ProductionPlanBean> searchMps(QueryBean queryBean) {
		// TODO Auto-generated method stub
		return productionPlanDAO.searchMps(queryBean);
	}
	@Override
	public void batchInventoryProcess(List<InventoryBean> InventoryList) {
	// TODO Auto-generated method stub
	  for(InventoryBean inventoryBean: InventoryList ){
		  if(inventoryBean.getStatus().equals("update")){
			  inventoryDAO.updateInventory(inventoryBean);
		  }
	  }
	}
	@Override
	public void batchSubulProcess(List<SubulRecordBean> subulList) {
		// TODO Auto-generated method stub
		SubulRecordBean resultSubulRecordBean=null;
		 for(SubulRecordBean subulRecordBean: subulList ){
			  if(subulRecordBean.getStatus().equals("insert")){
				resultSubulRecordBean =  subulRecordDAO.insertSubulRecord(subulRecordBean);
				String ErrorCode=resultSubulRecordBean.getErrorCode();
				String ErrorMsg=resultSubulRecordBean.getErrorMsg();
				if(ErrorCode.equals("-1")){
				throw new NoDataFoundException(ErrorMsg);
				}else if(ErrorCode.equals("-2")){
					System.out.println(ErrorCode+":"+ErrorMsg);
				throw new NotEnoughStockException(ErrorMsg);
				}else if(ErrorCode.equals("-3")){
					System.out.println(ErrorCode+":"+ErrorMsg);
				throw new OverflowStockException(ErrorMsg);	
				}else if(ErrorCode.equals("-4")){
				throw new RuntimeException(ErrorMsg);	
				}
				
			  }
		 
		 }
		 
	}
	@Override
	public void batchMpsProcess(List<ProductionPlanBean> ProductionPlanList) {
		// TODO Auto-generated method stub
		for(ProductionPlanBean productionPlanBean:ProductionPlanList){
			if(productionPlanBean.getStatus().equals("insert")){
				OrderInfoBean orderInfoBean=new OrderInfoBean();
				productionPlanDAO.insertproductionPlan(productionPlanBean);
				orderInfoBean.setOrderNo(productionPlanBean.getOrderNo());
				orderInfoBean.setPlanYN("1");
				orderInfoBean.setItemCode(productionPlanBean.getItemCode());
				orderInfoDAO.updateOrderInfo(orderInfoBean);
			}else if(productionPlanBean.getStatus().equals("update")){
				productionPlanDAO.updateproductionPlan(productionPlanBean);
			}else{
				productionPlanDAO.deleteproductionPlan(productionPlanBean);
				OrderInfoBean orderInfoBean=new OrderInfoBean();
				orderInfoBean.setOrderNo(productionPlanBean.getOrderNo());
				orderInfoBean.setPlanYN("0");
				orderInfoBean.setItemCode(productionPlanBean.getItemCode());
				orderInfoDAO.updateOrderInfo(orderInfoBean);
			}
		}
		
	}
	
}
