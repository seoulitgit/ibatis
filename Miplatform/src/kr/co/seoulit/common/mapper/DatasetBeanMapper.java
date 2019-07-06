package kr.co.seoulit.common.mapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.seoulit.common.annotation.Column;
import kr.co.seoulit.common.annotation.Remove;

import com.tobesoft.platform.PlatformResponse;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.PlatformData;
import com.tobesoft.platform.data.Variant;

@SuppressWarnings("rawtypes")
public class DatasetBeanMapper
{

	private String getDatasetName(Class classType)
	{

		String datasetName = null;
		Annotation[] annotations = classType.getAnnotations();

		for (Annotation annotation : annotations)
		{
			if (annotation instanceof kr.co.seoulit.common.annotation.Dataset)
				datasetName = ((kr.co.seoulit.common.annotation.Dataset) annotation).name();
		}

		return datasetName;
	}

	private String getColumnName(Method method)
	{
		String columnName = null;
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations)
		{
			if (annotation instanceof Column)
			{
				String annoValue = ((Column) annotation).name();
				columnName = annoValue;
			}

		}

		if (annotations.length == 0)
			columnName = formattingToSnake(method.getName());// m.getName()으로
																// 칼럼명을 만든다.

		return columnName;
	}

	private void setColumnName(Dataset dataset, Method method,
			Map<String, String> nameMapper)
	{

		if (method.getName().startsWith("get"))
		{
			Column column = method.getAnnotation(Column.class);
			Remove remove = method.getAnnotation(Remove.class);

			if (column != null)
			{
				dataset.addStringColumn(column.name());
				nameMapper.put(column.name(), method.getName());
			}
			else if (column == null && remove == null)
			{
				String columnName = formattingToSnake(method.getName());

				dataset.addStringColumn(columnName);
				nameMapper.put(columnName, method.getName());
			}
		}
	}

	private <T> void setColumn(Dataset dataset, Map<String, String> nameMapper,
			T bean) throws Exception
	{

		int rowIndex = dataset.appendRow();

		for (String columnName : nameMapper.keySet())
		{
			String methodName = nameMapper.get(columnName);

			Method method = bean.getClass().getDeclaredMethod(methodName, null);
			// 메서드명
			Variant value = new Variant(method.invoke(bean, null));
			dataset.setColumn(rowIndex, columnName, value);
		}

	}

	private <T> T setBean(Dataset dataset, Class<T> classType, int rowIndex,PlatformData inData)
			throws Exception
	{
		T bean = classType.newInstance();
		Method[] methods = classType.getDeclaredMethods();

		Method statusSetMethod = classType.getMethod("setStatus", String.class);
		statusSetMethod.invoke(bean, dataset.getRowStatus(rowIndex));

		for (Method method : methods)
		{
			if (method.getName().startsWith("set"))
			{

				String columnName = getColumnName(method);

				if (columnName != null)
				{
					int columnIndex = dataset.getColumnIndex(columnName);
					Variant columnValue = dataset.getColumn(rowIndex,
							columnIndex);
					if (columnValue != null){
						
						method.invoke(bean, columnValue.getString());
					
					}
				}
				else{
//			Object CompositeBean=Class.forName(method.getAnnotation(Composite.class).bean());
//			for(Object a:datasetToBeans(inData, CompositeBean)){
//				
//			}
//				
//			method.invoke(bean, datasetToBeans(inData, CompositeBean));
//			
				}

			}

		}

		return bean;
	}

	private <T> T setDeleteBean(Dataset dataset, Class<T> classType, int rowIndex)
			throws Exception
	{
		T bean = classType.newInstance();
		Method[] methods = classType.getDeclaredMethods();

		Method statusSetMethod = classType.getMethod("setStatus", String.class);
		statusSetMethod.invoke(bean, "delete");

		for (Method method : methods)
		{
			if (method.getName().startsWith("set"))
			{

				String columnName = getColumnName(method);
				if (columnName != null)
				{
					Variant columnValue = dataset.getDeleteColumn(rowIndex,
							columnName);
					if (columnValue != null){
						method.invoke(bean, columnValue.getString());
					}
					}
				}

			}

		
		return bean;
	}

	public <T> List<T> datasetToBeans(PlatformData inData, Class<T> classType)
			throws Exception
	{

		String datasetName = getDatasetName(classType);

		Dataset dataset = inData.getDataset(datasetName);

		T bean = null;

		List<T> beanList = new ArrayList<T>();

		int rowCount = dataset.getRowCount();

		// status가 insert update인 로우 -> bean으로 변환
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++)
		{
			bean = setBean(dataset, classType, rowIndex,inData);
			
			beanList.add(bean);
		}

		rowCount = dataset.getDeleteRowCount();

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++)
		{
			bean = setDeleteBean(dataset, classType, rowIndex);
			beanList.add(bean);
		}

		return beanList;

	}

	public <T> T datasetToBean(PlatformData inData, Class<T> classType)
			throws Exception
	{

		T bean = null;

		String datasetName = getDatasetName(classType);

		Dataset dataset = inData.getDataset(datasetName);
		System.out.println(dataset);
		if (dataset.getDeleteRowCount() == 0)
			bean = setBean(dataset, classType, 0,inData);
		else bean = setDeleteBean(dataset, classType, 0);

		return bean;
	}

	public <T> void beansToDataset(PlatformData outData, List<T> beanList,
			Class<T> classType) throws Exception
	{
		Map<String, String> nameMapper = new HashMap<String, String>();

		// 보낼 데이터셋 생성
		DatasetList datasetList = outData.getDatasetList();

		String datasetName = getDatasetName(classType);

		Dataset dataset = new Dataset(datasetName,
				PlatformResponse.CHARSET_EUC_KR, false, false);

		datasetList.addDataset(dataset);

		// 칼럼 생성 및 칼럼명과 메서드명 매칭
		Method[] methods = classType.getDeclaredMethods();
		for (Method method : methods)
			setColumnName(dataset, method, nameMapper);

		// 빈에 있는 데이터를 칼럼으로 복사
		for (T bean : beanList)
			setColumn(dataset, nameMapper, bean);

	}

	public <T> void beanToDataset(PlatformData outData, T bean, Class<T> classType)
			throws Exception
	{
		Map<String, String> nameMapper = new HashMap<>();

		DatasetList datasetList = outData.getDatasetList();

		String datasetName = getDatasetName(classType);

		Dataset dataset = new Dataset(datasetName,
				PlatformResponse.CHARSET_EUC_KR, false, false);

		datasetList.addDataset(dataset);

		if (bean != null)
		{
			Method[] methods = classType.getDeclaredMethods();

			// 칼럼 생성 및 칼럼명과 메서드명 매칭
			for (Method method : methods)
				setColumnName(dataset, method, nameMapper);
		}

		// 빈에 있는 데이터를 칼럼으로 복사
		setColumn(dataset, nameMapper, bean);

	}

	private String formattingToSnake(String name)
	{
		String regex = "([a-z])([A-Z])";
		String replacement = "$1_$2";

		name = name.substring(3); // set 또는 get 제거
		name = name.replaceAll(regex, replacement); // ..aA..bB.. ->

		return name.toLowerCase(); // ..A_A..B_B..
		//return name.toUpperCase();
	}

}