package kr.co.seoulit.logistics.base.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_bom")
public class BOMBean extends BaseBean{
	private String parentItemCode,itemGradeCode,procurementCode,unit,leadTime, itemCode,lossFactor,level;
	private String demandQuantity, netQuantity,itemName,parentItemName;
	
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
	public String getLeadTime() {
		return leadTime;
	}
	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getParentItemName() {
		return parentItemName;
	}
	public void setParentItemName(String parentItemName) {
		this.parentItemName = parentItemName;
	}
	public String getLossFactor() {
		return lossFactor;
	}
	public void setLossFactor(String lossFactor) {
		this.lossFactor = lossFactor;
	}
	
	public String getParentItemCode() {
		return parentItemCode;
	}
	public void setParentItemCode(String parentItemCode) {
		this.parentItemCode = parentItemCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getDemandQuantity() {
		return demandQuantity;
	}
	public void setDemandQuantity(String demandQuantity) {
		this.demandQuantity = demandQuantity;
	}
	public String getNetQuantity() {
		return netQuantity;
	}
	public void setNetQuantity(String netQuantity) {
		this.netQuantity = netQuantity;
	}

		
}