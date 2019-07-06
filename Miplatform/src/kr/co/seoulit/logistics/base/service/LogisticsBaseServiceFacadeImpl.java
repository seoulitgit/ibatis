package kr.co.seoulit.logistics.base.service;

import java.util.List;

import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.base.applicationservice.LogisticsBaseApplicationService;
import kr.co.seoulit.logistics.base.to.BOMBean;
import kr.co.seoulit.logistics.base.to.ItemBean;
import kr.co.seoulit.logistics.base.to.WarehouseBean;


public class LogisticsBaseServiceFacadeImpl implements LogisticsBaseServiceFacade {
	
	LogisticsBaseApplicationService logisticsBaseApplicationService;

	public void setLogisticsBaseApplicationService(
			LogisticsBaseApplicationService logisticsBaseApplicationService) {
		this.logisticsBaseApplicationService = logisticsBaseApplicationService;
	}
	@Override
	public List<WarehouseBean> getWarehouseList() {
		// TODO Auto-generated method stub
		return logisticsBaseApplicationService.getWarehouseList();
	}
	@Override
	public List<ItemBean> getItemList() {
		// TODO Auto-generated method stub
		return logisticsBaseApplicationService.getItemList();
	}
	@Override
	public void batchWarehouseProcess(List<WarehouseBean> warehouseList) {
		// TODO Auto-generated method stub
		logisticsBaseApplicationService.batchWarehouseProcess(warehouseList);
	}
	@Override
	public void batchItemGroupProcess(List<CodeBean> itemGroupList) {
		// TODO Auto-generated method stub
		logisticsBaseApplicationService.batchItemGroupProcess(itemGroupList);
	}
	@Override
	public void batchItemProcess(List<ItemBean> itemList) {
		// TODO Auto-generated method stub
		logisticsBaseApplicationService.batchItemProcess(itemList);
	}
	@Override
	public List<ItemBean> searchItemList(QueryBean query){
		return logisticsBaseApplicationService.searchItemList(query);
		
	}
	@Override
	public List<BOMBean> searchBOM(String itemCode) {
		// TODO Auto-generated method stub
		return logisticsBaseApplicationService.searchBOM(itemCode);
	}
	@Override
	public void batchBOMProcess(List<BOMBean> bomList) {
		// TODO Auto-generated method stub
		logisticsBaseApplicationService.batchBOMProcess(bomList);
	}
	@Override
	public List<BOMBean> unfoldBOM(String parentItemCode){
		return logisticsBaseApplicationService.unfoldBOM(parentItemCode);
	}
}

