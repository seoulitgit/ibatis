package kr.co.seoulit.base.service;

import java.util.List;

import kr.co.seoulit.base.to.CategoryCodeBean;
import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.base.to.CustomerBean;
import kr.co.seoulit.base.to.EmpBean;
import kr.co.seoulit.base.to.MenuAuthorityBean;
import kr.co.seoulit.base.to.MenuBean;
import kr.co.seoulit.base.to.PostBean;

public interface BaseServiceFacade {
	
	List<CategoryCodeBean> findCodeCategoryList();
	List<EmpBean> getEmpDataSet();
	List<CustomerBean> getCustomerList();
	List<MenuBean> getMenuDataSet();
	List<CodeBean> getCodeDataSet();
	List<MenuAuthorityBean> getMenuAuthority();
	List<CodeBean> findCodes(List<String> queryList);
	List<PostBean> findPostList(String dong);
	List<PostBean> findSidoList();
	List<PostBean> findSigunguList(String sido);
	List<PostBean> findRoadList(String sido, String sigungu,String roadname);
	void batchEmpProcess(List<EmpBean> empBeanList);
	void batchCodeProcess(List<CodeBean> codeBeanList);
	void batchMenuAuthProcess(List<MenuAuthorityBean> menuAuthList);
	void batchCustomerProcess(List<CustomerBean> customerList);
	EmpBean login(EmpBean empBean);
	}