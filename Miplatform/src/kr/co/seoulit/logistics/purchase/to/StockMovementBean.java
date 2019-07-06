package kr.co.seoulit.logistics.purchase.to;

import java.util.List;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.annotation.Remove;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_stock_movement")
public class StockMovementBean extends BaseBean{
	String movementNo,inWarehouseCode,outWarehouseCode;
	List<MovementItemBean> MovementItemList;
	public String getMovementNo() {
		return movementNo;
	}
	public void setMovementNo(String movementNo) {
		this.movementNo = movementNo;
	}
	public String getInWarehouseCode() {
		return inWarehouseCode;
	}
	public void setInWarehouseCode(String inWarehouseCode) {
		this.inWarehouseCode = inWarehouseCode;
	}
	public String getOutWarehouseCode() {
		return outWarehouseCode;
	}
	public void setOutWarehouseCode(String outWarehouseCode) {
		this.outWarehouseCode = outWarehouseCode;
	}
	@Remove
	public List<MovementItemBean> getMovementItemList() {
		return MovementItemList;
	}
	@Remove
	public void setMovementItemList(List<MovementItemBean> movementItemList) {
		MovementItemList = movementItemList;
	}

}
