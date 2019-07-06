package kr.co.seoulit.base.controller;

import java.util.ArrayList;
import java.util.List;

import kr.co.seoulit.base.service.BaseServiceFacade;
import kr.co.seoulit.base.to.CategoryCodeBean;
import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.common.controller.AbstractMiplatformController;

import com.tobesoft.platform.data.PlatformData;
import com.tobesoft.platform.data.Variable;
import com.tobesoft.platform.data.VariableList;


public class CodeController extends AbstractMiplatformController {
	
	BaseServiceFacade baseServiceFacade;

	
public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
		this.baseServiceFacade = baseServiceFacade;
	}
public void getCodelist(PlatformData inData, PlatformData outData) throws Exception {

	List<CodeBean> dsCode=baseServiceFacade.getCodeDataSet();
	List<CategoryCodeBean> dsCategoryCode=baseServiceFacade.findCodeCategoryList();
	
	datasetBeanMapper.beansToDataset(outData, dsCategoryCode , CategoryCodeBean.class);
	datasetBeanMapper.beansToDataset(outData, dsCode , CodeBean.class);
}                                                                                     

public void batchcodeProcess(PlatformData inData, PlatformData outData) throws Exception {

	List<CodeBean> codeBeanList=datasetBeanMapper.datasetToBeans(inData, CodeBean.class);
	baseServiceFacade.batchCodeProcess(codeBeanList);
}
public void getCodes(PlatformData inData, PlatformData outData) throws Exception {

	VariableList querys= inData.getVariableList();
	int querySize=querys.size();
	List<String> queryList=new ArrayList<String>();
	for(int i=0;i<querySize;i++){
		System.out.println(querys.get(i).getValue().getString());
		queryList.add(querys.get(i).getValue().getString());
	}
	List<CodeBean> codes=baseServiceFacade.findCodes(queryList);
	datasetBeanMapper.beansToDataset(outData, codes, CodeBean.class);
}

}


