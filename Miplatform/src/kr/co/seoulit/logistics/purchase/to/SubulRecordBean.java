package kr.co.seoulit.logistics.purchase.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_subul_record")
public class SubulRecordBean extends BaseBean{
String subulNo,itemCode,warehouseCode,subulDate,subulCode,customerCode;
String quantity,stockQuantity;
	
	public String getSubulNo() {
		return subulNo;
		}
	public void setSubulNo(String subulNo) {
		this.subulNo = subulNo;
		}
	public String getItemCode() {
		return itemCode;
		}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
		}
	public String getWarehouseCode() {
		return warehouseCode;
		}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
		}
	public String getSubulDate() {
		return subulDate;
		}
	public void setSubulDate(String subulDate) {
		this.subulDate = subulDate;
		}
	public String getSubulCode() {
		return subulCode;
		}
	public void setSubulCode(String subulCode) {
		this.subulCode = subulCode;
		}
	public String getCustomerCode() {
		return customerCode;
		}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
		}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}