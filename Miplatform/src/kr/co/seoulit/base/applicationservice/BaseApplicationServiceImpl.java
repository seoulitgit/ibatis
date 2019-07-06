package kr.co.seoulit.base.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.base.dao.CustomerDAO;
import kr.co.seoulit.base.dao.MenuAuthDAO;
import kr.co.seoulit.base.dao.CategoryCodeDAO;
import kr.co.seoulit.base.dao.CodeDAO;
import kr.co.seoulit.base.dao.EmpDAO;
import kr.co.seoulit.base.dao.PostDAO;
import kr.co.seoulit.base.exception.PwMismatchException;
import kr.co.seoulit.base.exception.UserNotFoundException;
import kr.co.seoulit.base.to.CategoryCodeBean;
import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.base.to.CustomerBean;
import kr.co.seoulit.base.to.EmpBean;
import kr.co.seoulit.base.to.MenuAuthorityBean;
import kr.co.seoulit.base.to.MenuBean;
import kr.co.seoulit.base.to.PostBean;

import org.springframework.context.support.ResourceBundleMessageSource;

public class BaseApplicationServiceImpl implements BaseApplicationService {
	ResourceBundleMessageSource messageSource;
	MenuAuthDAO menuAuthDAO;
	EmpDAO empDAO;
	CategoryCodeDAO categoryCodeDAO;
	CodeDAO codeDAO;
	PostDAO postDAO;
	CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}

	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

	public void setCategoryCodeDAO(CategoryCodeDAO categoryCodeDAO) {
		this.categoryCodeDAO = categoryCodeDAO;
	}

	public void setCodeDAO(CodeDAO codeDAO) {
		this.codeDAO = codeDAO;
	}

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public List<MenuBean> getMenuDataSet() {
		// TODO Auto-generated method stub
		return menuAuthDAO.getMenuDataSet();
	}

	@Override
	public List<EmpBean> getEmpDataSet() {
		// TODO Auto-generated method stub

		return empDAO.getEmpDataSet();
	}

	@Override
	public List<CustomerBean> getCustomerList() {
		// TODO Auto-generated method stub

		return customerDAO.getCustomerList();
	}

	public void setMenuAuthDAO(MenuAuthDAO menuAuthDAO) {
		this.menuAuthDAO = menuAuthDAO;
	}

	@Override
	public List<CodeBean> getCodeDataSet() {
		// TODO Auto-generated method stub

		return codeDAO.getCodeDataSet();
	}

	@Override
	public List<MenuAuthorityBean> getMenuAuthority() {
		// TODO Auto-generated method stub

		return menuAuthDAO.getMenuAuthority();
	}

	@Override
	public List<CodeBean> findCodes(List<String> quertList) {
		// TODO Auto-generated method stub

		return codeDAO.findCodes(quertList);
	}

	@Override
	public void batchEmpProcess(List<EmpBean> empBeanList) {
		// TODO Auto-generated method stub
		List<CodeBean> codeBeanList = new ArrayList<CodeBean>();
		for (EmpBean empBean : empBeanList) {
			CodeBean codeBean = new CodeBean();
			codeBean.setCode(empBean.getEmpNo());
			codeBean.setStatus(empBean.getStatus());
			codeBean.setValue(empBean.getEmpName());
			codeBean.setCategoryCode("BS-01");
			codeBean.setUseYN(empBean.getUseYn());
			codeBeanList.add(codeBean);
			if (empBean.getStatus().equals("insert")) {
				empDAO.insertEmp(empBean);
			} else if (empBean.getStatus().equals("update")) {
				empDAO.updateEmp(empBean);
			} else {
				empDAO.deleteEmp(empBean);
			}

		}
		batchCodeProcess(codeBeanList);

	}

	@Override
	public void batchCodeProcess(List<CodeBean> codeBeanList) {
		// TODO Auto-generated method stub
		for (CodeBean codeBean : codeBeanList) {
			if (codeBean.getStatus().equals("insert")) {
				codeDAO.insertCode(codeBean);
			} else if (codeBean.getStatus().equals("update")) {
				codeDAO.updateCode(codeBean);
			} else {
				codeDAO.deleteCode(codeBean);
			}

		}
	}

	public void batchMenuAuthProcess(List<MenuAuthorityBean> menuAuthList) {
		for (MenuAuthorityBean menuAuthorityBean : menuAuthList) {
			if (menuAuthorityBean.getStatus().equals("insert")) {
				menuAuthDAO.insertMenuAuth(menuAuthorityBean);
			} else {
				menuAuthDAO.deleteMenuAuth(menuAuthorityBean);
			}

		}
	}

	@Override
	public void batchCustomerProcess(List<CustomerBean> customerList) {
		// TODO Auto-generated method stub
		List<CodeBean> codeBeanList = new ArrayList<CodeBean>();
		for (CustomerBean customerBean : customerList) {
			CodeBean codeBean = new CodeBean();
			codeBean.setCode(customerBean.getCustomerCode());
			codeBean.setStatus(customerBean.getStatus());
			codeBean.setValue(customerBean.getCustomerName());
			codeBean.setCategoryCode("BS-03");
			codeBean.setUseYN(customerBean.getUseYn());
			codeBeanList.add(codeBean);
			if (customerBean.getStatus().equals("insert")) {
				customerDAO.insertCustomer(customerBean);
			} else if (customerBean.getStatus().equals("update")) {
				customerDAO.updateCustomer(customerBean);
			} else {
				customerDAO.deleteCustomer(customerBean);
			}
			batchCodeProcess(codeBeanList);

		}
	}

	public List<CategoryCodeBean> findCategoryCodeList() {

		List<CategoryCodeBean> codeCategoryList = categoryCodeDAO
				.findCodeCategoryList();

		return codeCategoryList;

	}

	@Override
	public EmpBean login(EmpBean empBean) throws UserNotFoundException,
			PwMismatchException {
		// TODO Auto-generated method stub

		EmpBean loginInfo = empDAO.findEmp(empBean);
		if (loginInfo != null) {
			System.out.println(loginInfo.getEmpPw() + empBean.getEmpPw());
			if (!loginInfo.getEmpPw().equals(empBean.getEmpPw())) {
				throw new PwMismatchException("비밀번호 오류");
			} else {
				return loginInfo;
			}
		} else {
			throw new UserNotFoundException("회원이 없습니다");
		}
	}

	@Override
	public List<PostBean> findPostList(String dong) {

		List<PostBean> postList = postDAO.searchPostList(dong);

		return postList;

	}

	@Override
	public List<PostBean> findSidoList() {

		List<PostBean> postList = postDAO.searchSidoList();

		return postList;
	}

	@Override
	public List<PostBean> findSigunguList(String sido) {

		List<PostBean> postSigunguList = postDAO.searchSigunguList(sido);

		return postSigunguList;

	}

	@Override
	public List<PostBean> findRoadList(String sido, String sigungu,
			String roadname) {
		String sidoTable = "ROAD_POST_" + sido;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sidoTable", sidoTable);
		map.put("sigungu", sigungu);
		map.put("roadname", roadname);
		List<PostBean> postRoadList = postDAO.searchRoadList(map);
		return postRoadList;
	}
}
