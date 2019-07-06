package kr.co.seoulit.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.CustomerBean;
import kr.co.seoulit.base.to.MenuAuthorityBean;
import kr.co.seoulit.base.to.MenuBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class CustomerDAOImpl extends SqlMapClientDaoSupport implements CustomerDAO {

	@Override
	public void deleteCustomer(CustomerBean customerBean) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("Customer.deleteCustomer", customerBean);
	}
	@Override
	public List<CustomerBean> getCustomerList() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Customer.getCustomerList");
	}
	@Override
	public void insertCustomer(CustomerBean customerBean) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Customer.insertCustomer", customerBean);
	}
	@Override
	public void updateCustomer(CustomerBean customerBean) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("Customer.updateCustomer", customerBean);
	}
	

}
