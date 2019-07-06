package kr.co.seoulit.logistics.purchase.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_movement_item")
public class MovementItemBean extends BaseBean{
String movementNo, itemCode;
int quantity;
public String getMovementNo() {
	return movementNo;
}
public void setMovementNo(String movementNo) {
	this.movementNo = movementNo;
}
public String getItemCode() {
	return itemCode;
}
public void setItemCode(String itemCode) {
	this.itemCode = itemCode;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}