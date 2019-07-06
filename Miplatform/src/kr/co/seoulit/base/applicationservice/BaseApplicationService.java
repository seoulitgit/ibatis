package kr.co.seoulit.base.applicationservice;

import java.util.List;

import kr.co.seoulit.base.exception.PwMismatchException;
import kr.co.seoulit.base.exception.UserNotFoundException;
import kr.co.seoulit.base.to.CategoryCodeBean;
import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.base.to.CustomerBean;
import kr.co.seoulit.base.to.EmpBean;
import kr.co.seoulit.base.to.MenuAuthorityBean;
import kr.co.seoulit.base.to.MenuBean;
import kr.co.seoulit.base.to.PostBean;

public interface BaseApplicationService {
	List<MenuBean> getMenuDataSet();
	List<EmpBean> getEmpDataSet();
	List<CodeBean> getCodeDataSet();
	List<CustomerBean> getCustomerList();
	List<MenuAuthorityBean> getMenuAuthority();
	List<CodeBean> findCodes(List<String> queryList);
	List<PostBean> findPostList(String dong);
	List<PostBean> findSidoList();
	List<PostBean> findSigunguList(String sido);
	List<PostBean> findRoadList(String sido, String sigungu,String roadname);
	void batchEmpProcess(List<EmpBean> empBeanList);
	void batchCodeProcess(List<CodeBean> codeBeanList);
	List<CategoryCodeBean> findCategoryCodeList();
	void batchMenuAuthProcess(List<MenuAuthorityBean> menuAuthList);
	void batchCustomerProcess(List<CustomerBean> customerList);
	EmpBean login(EmpBean empBean) throws UserNotFoundException,PwMismatchException;
}
