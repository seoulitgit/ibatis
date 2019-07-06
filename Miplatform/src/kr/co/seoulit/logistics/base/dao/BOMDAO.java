package kr.co.seoulit.logistics.base.dao;

import java.util.List;

import kr.co.seoulit.logistics.base.to.BOMBean;


public interface BOMDAO {
	List<BOMBean> searchBOM(String itemCode);
	List<BOMBean> unfoldBOM(String parentItemCode);
	void updateBOM(BOMBean bomBean);
	void deleteBOM(BOMBean bomBean);
	void insertBOM(BOMBean bomBean);
	}