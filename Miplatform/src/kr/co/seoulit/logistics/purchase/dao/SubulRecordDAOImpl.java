package kr.co.seoulit.logistics.purchase.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;
import kr.co.seoulit.logistics.purchase.to.SubulRecordBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class SubulRecordDAOImpl extends SqlMapClientDaoSupport implements SubulRecordDAO {
	 
@Override
public List<SubulRecordBean> searchSubul(QueryBean query) {
			// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForList("Subul.searchSubul",query);
		}

@Override
	public SubulRecordBean insertSubulRecord(SubulRecordBean subulRecordBean) {
		// TODO Auto-generated method stub
	getSqlMapClientTemplate().queryForObject("Subul.insertSubulRecord", subulRecordBean);
	return subulRecordBean;
}
}
