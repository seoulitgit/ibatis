package kr.co.seoulit.logistics.purchase.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_mrp")
public class MRPBean extends BaseBean{
String itemCode,itemGradeCode,strDate,endDate;
String demandQuantity,unit,leadTime,lossFactor;
public String getItemCode() {
	return itemCode;
}
public void setItemCode(String itemCode) {
	this.itemCode = itemCode;
}
public String getItemGradeCode() {
	return itemGradeCode;
}
public void setItemGradeCode(String itemGradeCode) {
	this.itemGradeCode = itemGradeCode;
}
public String getStrDate() {
	return strDate;
}
public void setStrDate(String strDate) {
	this.strDate = strDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getDemandQuantity() {
	return demandQuantity;
}
public void setDemandQuantity(String demandQuantity) {
	this.demandQuantity = demandQuantity;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public String getLeadTime() {
	return leadTime;
}
public void setLeadTime(String leadTime) {
	this.leadTime = leadTime;
}
public String getLossFactor() {
	return lossFactor;
}
public void setLossFactor(String lossFactor) {
	this.lossFactor = lossFactor;
}
}