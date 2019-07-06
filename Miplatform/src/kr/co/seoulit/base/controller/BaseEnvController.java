package kr.co.seoulit.base.controller;

import java.util.List;

import kr.co.seoulit.base.service.BaseServiceFacade;
import kr.co.seoulit.base.to.CustomerBean;
import kr.co.seoulit.base.to.MenuAuthorityBean;
import kr.co.seoulit.base.to.MenuBean;
import kr.co.seoulit.common.controller.AbstractMiplatformController;

import com.tobesoft.platform.data.PlatformData;


public class BaseEnvController extends AbstractMiplatformController {
	
	BaseServiceFacade baseServiceFacade;

	
public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
		this.baseServiceFacade = baseServiceFacade;
	}
public void getBaseEnv(PlatformData inData, PlatformData outData) throws Exception {

	
	List<MenuBean> dsMenu=baseServiceFacade.getMenuDataSet();
	
	
	datasetBeanMapper.beansToDataset(outData, dsMenu , MenuBean.class);
}
public void getMenuAuthority(PlatformData inData, PlatformData outData) throws Exception {

	
	List<MenuAuthorityBean> dsMenuAuth=baseServiceFacade.getMenuAuthority();
	
	
	datasetBeanMapper.beansToDataset(outData, dsMenuAuth , MenuAuthorityBean.class);
}
public void batchMenuAuthProcess(PlatformData inData, PlatformData outData) throws Exception {

	List<MenuAuthorityBean> menuAuthList=datasetBeanMapper.datasetToBeans(inData, MenuAuthorityBean.class);
	baseServiceFacade.batchMenuAuthProcess(menuAuthList);
}
public void batchCustomerProcess(PlatformData inData, PlatformData outData) throws Exception {
	List<CustomerBean> customerList=datasetBeanMapper.datasetToBeans(inData, CustomerBean.class);
	baseServiceFacade.batchCustomerProcess(customerList);
}
public void getCustomerList(PlatformData inData, PlatformData outData) throws Exception {

	
	List<CustomerBean> dsCustomer=baseServiceFacade.getCustomerList();
	
	
	datasetBeanMapper.beansToDataset(outData, dsCustomer , CustomerBean.class);
}
}



