package kr.co.seoulit.base.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.seoulit.base.applicationservice.BaseApplicationService;
import kr.co.seoulit.base.exception.PwMismatchException;
import kr.co.seoulit.base.exception.UserNotFoundException;
import kr.co.seoulit.base.to.CategoryCodeBean;
import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.base.to.CustomerBean;
import kr.co.seoulit.base.to.EmpBean;
import kr.co.seoulit.base.to.MenuAuthorityBean;
import kr.co.seoulit.base.to.MenuBean;
import kr.co.seoulit.base.to.PostBean;

public class BaseServiceFacadeImpl implements BaseServiceFacade {

	BaseApplicationService baseApplicationService;
	
public void setBaseApplicationService(
			BaseApplicationService authApplicationService) {
		this.baseApplicationService = authApplicationService;
	}



	public List<CategoryCodeBean> findCodeCategoryList() {

		List<CategoryCodeBean> codeCategoryList = 
				baseApplicationService.findCategoryCodeList();

		return codeCategoryList;

	}
	@Override
	public List<EmpBean> getEmpDataSet() {
		// TODO Auto-generated method stub
		List<EmpBean> empDs=baseApplicationService.getEmpDataSet();
		return empDs;
	}
	@Override
	public List<CustomerBean> getCustomerList() {
		// TODO Auto-generated method stub
		List<CustomerBean> dsCustomer=baseApplicationService.getCustomerList();
		return dsCustomer;
	}
	@Override
	public List<MenuBean> getMenuDataSet() {
		// TODO Auto-generated method stub
		List<MenuBean> menuDs=baseApplicationService.getMenuDataSet();
		return menuDs;
	}
	@Override
	public List<CodeBean> getCodeDataSet() {
		// TODO Auto-generated method stub
		List<CodeBean> codeDs=baseApplicationService.getCodeDataSet();
		return codeDs;
	}
	@Override
	public List<MenuAuthorityBean> getMenuAuthority() {
		// TODO Auto-generated method stub
		List<MenuAuthorityBean> dsMenuAuth=baseApplicationService.getMenuAuthority();
		return dsMenuAuth;
	}
	@Override
	public List<CodeBean> findCodes(List<String> queryList) {
		// TODO Auto-generated method stub
		List<CodeBean> codeDs=baseApplicationService.findCodes(queryList);
		return codeDs;
	}
	
	@Override
	public void batchEmpProcess(List<EmpBean> empBeanList) {
		// TODO Auto-generated method stub
		baseApplicationService.batchEmpProcess(empBeanList);
	}
	@Override
	public void batchCodeProcess(List<CodeBean> codeBeanList) {
		// TODO Auto-generated method stub
		baseApplicationService.batchCodeProcess(codeBeanList);
	}
	@Override
	public void batchMenuAuthProcess(List<MenuAuthorityBean> menuAuthList) {
		// TODO Auto-generated method stub
		baseApplicationService.batchMenuAuthProcess(menuAuthList);
	}
	@Override
	public void batchCustomerProcess(List<CustomerBean> customerList) {
		// TODO Auto-generated method stub
		baseApplicationService.batchCustomerProcess(customerList);
	}
	@Override
	public EmpBean login(EmpBean empBean) {
		// TODO Auto-generated method stub
		
		return baseApplicationService.login(empBean);
	}
	@Override
	public List<PostBean> findPostList(String dong) {

		List<PostBean> postList = baseApplicationService
				.findPostList(dong);

		return postList;

	}

	@Override
	public List<PostBean> findSidoList() {

		List<PostBean> postList = baseApplicationService.findSidoList();

		return postList;
	}

	@Override
	public List<PostBean> findSigunguList(String sido) {

		List<PostBean> postSigunguList = baseApplicationService
				.findSigunguList(sido);

		return postSigunguList;

	}

	@Override
	public List<PostBean> findRoadList(String sido, String sigungu,
			String roadname) {

		List<PostBean> postRoadList = baseApplicationService.findRoadList(
				sido, sigungu, roadname);

		return postRoadList;
	}
}

