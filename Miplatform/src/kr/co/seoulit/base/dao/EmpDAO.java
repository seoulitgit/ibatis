package kr.co.seoulit.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.CategoryCodeBean;
import kr.co.seoulit.base.to.DeptBean;
import kr.co.seoulit.base.to.EmpBean;




public interface EmpDAO {
	List<EmpBean> getEmpDataSet();
	void updateEmp(EmpBean empBean);
	void deleteEmp(EmpBean empBean);
	void insertEmp(EmpBean empBean);
	EmpBean findEmp(EmpBean empBean);
	}
