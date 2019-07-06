package kr.co.seoulit.logistics.business.to;

import java.util.List;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.annotation.Remove;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_orders")
public class OrderBean extends BaseBean{
	private String orderNo,customerCode, appointedDate,orderDate;
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	private List<OrderInfoBean> orderInfoList;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getAppointedDate() {
		return appointedDate;
	}
	public void setAppointedDate(String appointedDate) {
		this.appointedDate = appointedDate;
	}
	@Remove
	public List<OrderInfoBean> getOrderInfoList() {
		return orderInfoList;
	}
	@Remove
	public void setOrderInfoList(List<OrderInfoBean> orderInfoList) {
		this.orderInfoList = orderInfoList;
	}
	
}