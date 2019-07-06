package kr.co.seoulit.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.CategoryCodeBean;
import kr.co.seoulit.base.to.EmpBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EmpDAOImpl extends SqlMapClientDaoSupport implements EmpDAO {

	@Override
	public List<EmpBean> getEmpDataSet() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Emp.getEmpDataSet");
	}

	@Override
	public void deleteEmp(EmpBean empBean) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("Emp.deleteEmp", empBean);
	}

	@Override
	public void insertEmp(EmpBean empBean) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("Emp.insertEmp", empBean);
	}

	@Override
	public void updateEmp(EmpBean empBean) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("Emp.updateEmp", empBean);
	}

	@Override
	public EmpBean findEmp(EmpBean empBean) {
		// TODO Auto-generated method stub
		
		return (EmpBean)getSqlMapClientTemplate().queryForObject("Emp.findEmp",empBean);
	}

}
