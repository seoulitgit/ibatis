package kr.co.seoulit.base.controller;

import kr.co.seoulit.base.service.BaseServiceFacade;
import kr.co.seoulit.base.to.EmpBean;
import kr.co.seoulit.common.controller.AbstractMiplatformController;

import com.tobesoft.platform.data.PlatformData;


public class LoginController extends AbstractMiplatformController {
	
	BaseServiceFacade baseServiceFacade;

	
public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
		this.baseServiceFacade = baseServiceFacade;
	}
public void login(PlatformData inData, PlatformData outData) throws Exception {

	String empNo=inData.getVariable("emp_no").getValue().getString();
	String empPw=inData.getVariable("emp_pw").getValue().getString();
	EmpBean empBean=new EmpBean();
	empBean.setEmpNo(empNo);
	empBean.setEmpPw(empPw);
	EmpBean userInfo=baseServiceFacade.login(empBean);
	datasetBeanMapper.beanToDataset(outData, userInfo, EmpBean.class);
}                                                                                     


}


