package kr.co.seoulit.base.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_customer")
public class CustomerBean extends BaseBean{
String customerCode,customerName,ceoName,customerTel,useYn;

public String getUseYn() {
	return useYn;
}

public void setUseYn(String useYn) {
	this.useYn = useYn;
}

public String getCustomerCode() {
	return customerCode;
}

public void setCustomerCode(String customerCode) {
	this.customerCode = customerCode;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getCeoName() {
	return ceoName;
}

public void setCeoName(String ceoName) {
	this.ceoName = ceoName;
}

public String getCustomerTel() {
	return customerTel;
}

public void setCustomerTel(String customerTel) {
	this.customerTel = customerTel;
}
}