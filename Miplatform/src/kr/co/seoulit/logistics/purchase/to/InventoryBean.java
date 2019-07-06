package kr.co.seoulit.logistics.purchase.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_inventory")
public class InventoryBean extends BaseBean{
String itemCode,warehouseCode,stockQuantity,reorderPoint;
String maxStock,warehouseName,itemName,itemGroupCode,itemGroupName,unit;
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
public String getStockQuantity() {
	return stockQuantity;
}
public void setStockQuantity(String stockQuantity) {
	this.stockQuantity = stockQuantity;
}
public String getReorderPoint() {
	return reorderPoint;
}
public void setReorderPoint(String reorderPoint) {
	this.reorderPoint = reorderPoint;
}
public String getMaxStock() {
	return maxStock;
}
public void setMaxStock(String maxStock) {
	this.maxStock = maxStock;
}
public String getWarehouseName() {
	return warehouseName;
}
public void setWarehouseName(String warehouseName) {
	this.warehouseName = warehouseName;
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
public String getItemGroupName() {
	return itemGroupName;
}
public void setItemGroupName(String itemGroupName) {
	this.itemGroupName = itemGroupName;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}


}