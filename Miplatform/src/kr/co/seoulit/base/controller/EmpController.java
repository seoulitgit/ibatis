package kr.co.seoulit.base.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import kr.co.seoulit.base.service.BaseServiceFacade;
import kr.co.seoulit.base.to.EmpBean;
import kr.co.seoulit.common.controller.AbstractMiplatformController;

import org.springframework.context.support.ResourceBundleMessageSource;

import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.PlatformData;

public class EmpController extends AbstractMiplatformController {

	BaseServiceFacade baseServiceFacade;
	ResourceBundleMessageSource message;

	public void setMessage(ResourceBundleMessageSource messageSource) {
		this.message = messageSource;
	}

	public void setBaseServiceFacade(BaseServiceFacade baseServiceFacade) {
		this.baseServiceFacade = baseServiceFacade;
	}

	public void batchEmpProcess(PlatformData inData, PlatformData outData)
			throws Exception {
		DatasetList inDsList = inData.getDatasetList();
		Dataset empDs = inDsList.getDataset("ds_emp");
		int datasetSize = empDs.getRowCount();
		List<EmpBean> empBeanList = datasetBeanMapper.datasetToBeans(inData,
				EmpBean.class);
		for (int i = 0; i < datasetSize; i++) {

			byte[] img = empDs.getColumnAsByteArray(i, "image");

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
				empBeanList.get(i).setImageFile("image::" + name);
				System.out.println(empBeanList.get(i).getImageFile());
			}
		}
		baseServiceFacade.batchEmpProcess(empBeanList);
		// List<CategoryCodeBean>
		// dscodeList=baseServiceFacade.findCodeCategoryList();

		// datasetBeanMapper.beansToDataset(outData,dscodeList,
		// CategoryCodeBean.class);
	}

	public void getEmpDataSet(PlatformData inData, PlatformData outData)
			throws Exception {

		List<EmpBean> dsEmp = baseServiceFacade.getEmpDataSet();

		datasetBeanMapper.beansToDataset(outData, dsEmp, EmpBean.class);
	}


}
