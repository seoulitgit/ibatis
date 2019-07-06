package kr.co.seoulit.logistics.purchase.dao;

import java.util.List;

import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.purchase.to.InventoryBean;
import kr.co.seoulit.logistics.purchase.to.SubulRecordBean;


public interface SubulRecordDAO {
	List<SubulRecordBean> searchSubul(QueryBean query);
	SubulRecordBean insertSubulRecord(SubulRecordBean subulRecordBean);
	
}