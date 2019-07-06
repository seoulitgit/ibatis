package kr.co.seoulit.common.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.common.mapper.DatasetBeanMapper;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.PlatformResponse;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.PlatformData;
import com.tobesoft.platform.data.VariableList;
public abstract class AbstractMiplatformController extends AbstractController {
	protected DatasetBeanMapper datasetBeanMapper;

	public void setDatasetBeanMapper(DatasetBeanMapper datasetBeanMapper) {
		this.datasetBeanMapper = datasetBeanMapper;
	}

@Override
protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	
	PlatformRequest platformRequest = new PlatformRequest(request, "utf-8");
	platformRequest.receiveData();

	PlatformData inData = platformRequest.getPlatformData();

	PlatformData outData = new PlatformData(new VariableList(), new DatasetList());

	String methodName=request.getParameter("method");
	Class<? extends AbstractMiplatformController> controllerClass=getClass();

	Method method= null;

	try {
		method=controllerClass.getDeclaredMethod(methodName,PlatformData.class, PlatformData.class);

		method.invoke(this, inData, outData);

		outData.getVariableList().add("ErrorCode", 0);
		outData.getVariableList().addStr("ErrorMsg","success");
	} catch(InvocationTargetException invocationTargetException){

		Throwable mainException=invocationTargetException.getCause();
		invocationTargetException.printStackTrace();
		outData.getVariableList().add("ErrorCode", -1);
		outData.getVariableList().addStr("ErrorMsg", mainException.getMessage());


	} catch (Exception e) {
		e.printStackTrace();
		outData.getVariableList().add("ErrorCode", -1);
		outData.getVariableList().addStr("ErrorMsg", e.getMessage());
	}

	PlatformResponse platformResponse = new PlatformResponse(response,PlatformRequest.XML, "utf-8");
	platformResponse.sendData(outData);
	//Debug
	outData.getVariableList().printVariables();
	outData.clear();
	outData = null;

	return null;
}
public String getFileName() {
	long currentTime = System.currentTimeMillis();
	int randomValue = new Random().nextInt(10000);
	String tempfilename = currentTime + "_" + randomValue;
	return tempfilename;
}
}


