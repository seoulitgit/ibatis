package kr.co.seoulit.logistics.base.dao;

import java.util.List;

import kr.co.seoulit.logistics.base.to.BOMBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class BOMDAOImpl extends SqlMapClientDaoSupport implements BOMDAO {
	 
@Override
public List<BOMBean> searchBOM(String itemCode) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("BOM.searchBOM",itemCode);
}
	@Override
		public List<BOMBean> unfoldBOM(String parentItemCode) {
			// TODO Auto-generated method stub
			return getSqlMapClientTemplate().queryForList("BOM.unfoldBOM",parentItemCode);
		}
	@Override
		public void deleteBOM(BOMBean bomBean) {
			// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("BOM.deleteBOM",bomBean);
		}
	@Override
		public void insertBOM(BOMBean bomBean) {
				// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("BOM.insertBOM",bomBean);
		}
	@Override
		public void updateBOM(BOMBean bomBean) {
					// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("BOM.updateBOM",bomBean);
		
		}
	
}
