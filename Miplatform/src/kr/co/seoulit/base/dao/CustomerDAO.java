package kr.co.seoulit.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.CustomerBean;
import kr.co.seoulit.base.to.MenuAuthorityBean;
import kr.co.seoulit.base.to.MenuBean;




public interface CustomerDAO {
	List<CustomerBean> getCustomerList();
	void insertCustomer(CustomerBean customerBean);
	void deleteCustomer(CustomerBean customerBean);
	void updateCustomer(CustomerBean customerBean);
	
	}
