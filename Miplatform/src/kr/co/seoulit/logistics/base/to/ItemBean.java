package kr.co.seoulit.logistics.base.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_item")
public class ItemBean extends BaseBean{
	private String itemCode, itemName, itemGroupCode, itemGradeCode, procurementCode,
					unit, customerCode, image;
	private String leadTime, lossFactor, standardCost,useYn,customerName;
	
	public String getUseYn() {
		return useYn;
	}
	public String getLeadTime() {
		return leadTime;
	}
	public String getLossFactor() {
		return lossFactor;
	}
	public String getStandardCost() {
		return standardCost;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}
	public void setLossFactor(String lossFactor) {
		this.lossFactor = lossFactor;
	}
	public void setStandardCost(String standardCost) {
		this.standardCost = standardCost;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemGroupCode() {
		return itemGroupCode;
	}
	public void setItemGroupCode(String itemGroupCode) {
		this.itemGroupCode = itemGroupCode;
	}
	public String getItemGradeCode() {
		return itemGradeCode;
	}
	public void setItemGradeCode(String itemGradeCode) {
		this.itemGradeCode = itemGradeCode;
	}
	public String getProcurementCode() {
		return procurementCode;
	}
	public void setProcurementCode(String procurementCode) {
		this.procurementCode = procurementCode;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
			
}