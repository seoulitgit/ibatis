package kr.co.seoulit.base.controller;

import java.util.List;

import kr.co.seoulit.base.service.BaseServiceFacade;
import kr.co.seoulit.base.to.PostBean;
import kr.co.seoulit.common.controller.AbstractMiplatformController;

import com.tobesoft.platform.data.PlatformData;
import com.tobesoft.platform.data.Variable;

public class PostController extends AbstractMiplatformController {

	BaseServiceFacade baseServiceFacade;

	public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
		this.baseServiceFacade = baseServiceFacade;
	}

	public void searchJibun(PlatformData inData, PlatformData outData) throws Exception {
		Variable variable=inData.getVariable("dong");
		String dong=variable.getValue().getString();
		List<PostBean> postList=baseServiceFacade.findPostList(dong);
		datasetBeanMapper.beansToDataset(outData, postList, PostBean.class);
		
			
	}
	public void searchSidoList(PlatformData inData, PlatformData outData) throws Exception {
	
		List<PostBean> sidoList=baseServiceFacade.findSidoList();
		datasetBeanMapper.beansToDataset(outData, sidoList, PostBean.class);
		
		
	}
	public void searchSigunguList(PlatformData inData, PlatformData outData) throws Exception {
		Variable variable=inData.getVariable("sidoCode");
		String sidoCode=variable.getValue().getString();
		List<PostBean> sisunguList=baseServiceFacade.findSigunguList(sidoCode);
		datasetBeanMapper.beansToDataset(outData, sisunguList, PostBean.class);
		
	}
	public void searchRoadnameList(PlatformData inData, PlatformData outData) throws Exception {
		
		String sidoCode=inData.getVariable("sidoCode").getValue().getString();
		String sigunguName=inData.getVariable("sigunguName").getValue().getString();
		String roadName=inData.getVariable("roadName").getValue().getString();
		
		List<PostBean> roadList=baseServiceFacade.findRoadList(sidoCode, sigunguName, roadName);
		datasetBeanMapper.beansToDataset(outData, roadList, PostBean.class);
	}
	
}
