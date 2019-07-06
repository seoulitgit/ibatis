package kr.co.seoulit.logistics.base.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.common.controller.AbstractMiplatformController;
import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.base.service.LogisticsBaseServiceFacade;
import kr.co.seoulit.logistics.base.to.ItemBean;

import org.springframework.context.support.ResourceBundleMessageSource;

import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.PlatformData;


public class ItemController extends AbstractMiplatformController {
	
	LogisticsBaseServiceFacade logisticsBaseServiceFacade;
	ResourceBundleMessageSource message;
	
	public void setMessage(ResourceBundleMessageSource message) {
		this.message = message;
	}

	public void setLogisticsBaseServiceFacade(  
			LogisticsBaseServiceFacade logisticsBaseServiceFacade) {
		this.logisticsBaseServiceFacade = logisticsBaseServiceFacade;
	}

	public void getItemList(PlatformData inData, PlatformData outData) throws Exception {
		List<ItemBean> itemList=logisticsBaseServiceFacade.getItemList();
		datasetBeanMapper.beansToDataset(outData, itemList, ItemBean.class);
		
	}
	public void batchItemProcess(PlatformData inData, PlatformData outData) throws Exception {
		
		List<CodeBean> itemGroupCodeList=datasetBeanMapper.datasetToBeans(inData, CodeBean.class);
		
		logisticsBaseServiceFacade.batchItemGroupProcess(itemGroupCodeList);
		
		DatasetList inDsList = inData.getDatasetList();
		Dataset itemDs = inDsList.getDataset("ds_item");
		int datasetSize = itemDs.getRowCount();
		List<ItemBean> itemBeanList = datasetBeanMapper.datasetToBeans(inData,
				ItemBean.class);
		System.out.println(datasetSize);
		for (int i = 0; i < datasetSize; i++) {

			byte[] img = itemDs.getColumnAsByteArray(i, "IMAGEFILE");

			if (img != null) {
				String path = message.getMessage("path", null, null);
				String name = getFileName() + ".jpg";
				FileOutputStream fos = new FileOutputStream(new File(path
						+ name));
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				bos.write(img);
				bos.flush();
				fos.close();
				bos.close();
				itemBeanList.get(i).setImage("image::" + name);
				System.out.println(itemBeanList.get(i).getImage());
			}
		}
		logisticsBaseServiceFacade.batchItemProcess(itemBeanList);
		
	}
	
	public void searchItemList(PlatformData inData, PlatformData outData) throws Exception {
		QueryBean queryBean=datasetBeanMapper.datasetToBean(inData, QueryBean.class);
		List<ItemBean> itemList=logisticsBaseServiceFacade.searchItemList(queryBean);
		datasetBeanMapper.beansToDataset(outData, itemList, ItemBean.class);
	}
}


