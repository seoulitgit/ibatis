package kr.co.seoulit.logistics.base.to;

import java.util.List;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.annotation.Remove;
import kr.co.seoulit.common.to.BaseBean;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;

@Dataset(name="ds_warehouse")
public class WarehouseBean extends BaseBean{
String warehouseCode,warehouseName,managerNo,managerName,useYn;
public String getUseYn() {
	return useYn;
}
public void setUseYn(String useYn) {
	this.useYn = useYn;
}
public String getManagerName() {
	return managerName;
}
public void setManagerName(String managerName) {
	this.managerName = managerName;
}
List<InventoryBean> InventoryList;
public String getWarehouseCode() {
	return warehouseCode;
}
public void setWarehouseCode(String warehouseCode) {
	this.warehouseCode = warehouseCode;
}
public String getWarehouseName() {
	return warehouseName;
}
public void setWarehouseName(String warehouseName) {
	this.warehouseName = warehouseName;
}
public String getManagerNo() {
	return managerNo;
}
public void setManagerNo(String managerNo) {
	this.managerNo = managerNo;
}
@Remove
public List<InventoryBean> getInventoryList() {
	return InventoryList;
}
@Remove
public void setInventoryList(List<InventoryBean> inventoryList) {
	InventoryList = inventoryList;
}

}