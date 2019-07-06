package kr.co.seoulit.logistics.base.applicationservice;

import java.util.List;

import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.base.to.BOMBean;
import kr.co.seoulit.logistics.base.to.ItemBean;
import kr.co.seoulit.logistics.base.to.WarehouseBean;


public interface LogisticsBaseApplicationService {
	List<WarehouseBean> getWarehouseList();
	List<ItemBean> getItemList();
	List<ItemBean> searchItemList(QueryBean query);
	List<BOMBean> searchBOM(String itemCode);
	List<BOMBean> unfoldBOM(String parentItemCode);
	void batchWarehouseProcess(List<WarehouseBean> warehouseList);
	void batchItemGroupProcess(List<CodeBean> itemGroupList);
	void batchItemProcess(List<ItemBean> itemList);
	void batchBOMProcess(List<BOMBean> bomList);
	
	}