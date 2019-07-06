package kr.co.seoulit.base.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.base.to.CodeBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class CodeDAOImpl extends SqlMapClientDaoSupport implements CodeDAO {
	 

	@Override
	public List<CodeBean> getCodeDataSet(){
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Code.getCodeDataSet");
		

	}	
	@Override
	public List<CodeBean> findCodes(List<String> queryList){
		// TODO Auto-generated method stub
		HashMap<String, List> hashMap=new HashMap<String, List>();
		hashMap.put("queryList", queryList);
		return getSqlMapClientTemplate().queryForList("Code.findCodes",hashMap);
	
		

	}		
	
	public void insertCode(CodeBean codeBean){
		getSqlMapClientTemplate().insert("Code.insertCode",codeBean);

	}
	public void deleteCode(CodeBean codeBean){
		getSqlMapClientTemplate().delete("Code.deleteCode",codeBean);

	}
	public void updateCode(CodeBean codeBean){
		getSqlMapClientTemplate().update("Code.updateCode",codeBean);

	}
}
