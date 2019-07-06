package kr.co.seoulit.logistics.business.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_order_info")
public class OrderInfoBean extends BaseBean{
	private String orderNo, itemCode, releaseYN, planYN,processYN;
	public String getProcessYN() {
		return processYN;
	}
	public void setProcessYN(String processYN) {
		this.processYN = processYN;
	}
	private String quantity, productionQuantity, unitCost;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getReleaseYN() {
		return releaseYN;
	}
	public void setReleaseYN(String releaseYN) {
		this.releaseYN = releaseYN;
	}
	public String getPlanYN() {
		return planYN;
	}
	public void setPlanYN(String planYN) {
		this.planYN = planYN;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getProductionQuantity() {
		return productionQuantity;
	}
	public void setProductionQuantity(String productionQuantity) {
		this.productionQuantity = productionQuantity;
	}
	public String getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}
	
	
}