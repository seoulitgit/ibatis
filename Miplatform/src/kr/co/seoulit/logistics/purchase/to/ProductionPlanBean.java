package kr.co.seoulit.logistics.purchase.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_production_plan")
public class ProductionPlanBean extends BaseBean{
String productionPlanNo,planCode,itemCode,orderNo,planDate,planQuantity;

public String getProductionPlanNo() {
	return productionPlanNo;
}

public void setProductionPlanNo(String productionPlanNo) {
	this.productionPlanNo = productionPlanNo;
}

public String getPlanCode() {
	return planCode;
}

public void setPlanCode(String planCode) {
	this.planCode = planCode;
}

public String getItemCode() {
	return itemCode;
}

public void setItemCode(String itemCode) {
	this.itemCode = itemCode;
}

public String getOrderNo() {
	return orderNo;
}

public void setOrderNo(String orderNo) {
	this.orderNo = orderNo;
}

public String getPlanDate() {
	return planDate;
}

public void setPlanDate(String planDate) {
	this.planDate = planDate;
}

public String getPlanQuantity() {
	return planQuantity;
}

public void setPlanQuantity(String planQuantity) {
	this.planQuantity = planQuantity;
}


}