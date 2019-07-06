package kr.co.seoulit.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.CodeBean;


public interface CodeDAO {
	List<CodeBean> getCodeDataSet();
	List<CodeBean> findCodes(List<String> queryList);
	void updateCode(CodeBean codeInfoBean);
	void deleteCode(CodeBean codeInfoBean);
	void insertCode(CodeBean codeInfoBean);
	}