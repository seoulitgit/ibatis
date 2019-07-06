package kr.co.seoulit.base.to;

import java.util.List;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.annotation.Remove;

@Dataset(name="ds_category_code")
public class CategoryCodeBean {
	private String categoryCode, categoryValue, modiYN;
	private List<CodeBean> codeBeanList;
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryValue() {
		return categoryValue;
	}
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
	public String getModiYN() {
		return modiYN;
	}
	public void setModiYN(String modiYN) {
		this.modiYN = modiYN;
	}
	@Remove
	public List<CodeBean> getCodeBeanList() {
		return codeBeanList;
	}
	@Remove
	public void setCodeBeanList(List<CodeBean> codeBeanList) {
		this.codeBeanList = codeBeanList;
	}
	
}