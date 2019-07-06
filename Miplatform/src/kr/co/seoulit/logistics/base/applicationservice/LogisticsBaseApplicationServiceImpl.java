package kr.co.seoulit.logistics.base.applicationservice;

import java.util.ArrayList;
import java.util.List;

import kr.co.seoulit.base.applicationservice.BaseApplicationService;
import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.base.to.EmpBean;
import kr.co.seoulit.common.to.QueryBean;
import kr.co.seoulit.logistics.base.dao.BOMDAO;
import kr.co.seoulit.logistics.base.dao.ItemDAO;
import kr.co.seoulit.logistics.base.dao.WarehouseDAO;
import kr.co.seoulit.logistics.base.to.BOMBean;
import kr.co.seoulit.logistics.base.to.ItemBean;
import kr.co.seoulit.logistics.base.to.WarehouseBean;

import org.springframework.context.support.ResourceBundleMessageSource;

public class LogisticsBaseApplicationServiceImpl implements
		LogisticsBaseApplicationService {

	ResourceBundleMessageSource messageSource;
	BaseApplicationService baseApplicationService;
	
	public void setBaseApplicationService(
			BaseApplicationService baseApplicationService) {
		this.baseApplicationService = baseApplicationService;
	}
	BOMDAO bomDAO;
	ItemDAO itemDAO;
	WarehouseDAO warehouseDAO;

	public void setBomDAO(BOMDAO bomDAO) {
		this.bomDAO = bomDAO;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public void setWarehouseDAO(WarehouseDAO warehouseDAO) {
		this.warehouseDAO = warehouseDAO;
	}

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public List<WarehouseBean> getWarehouseList() {
		// TODO Auto-generated method stub
		return warehouseDAO.getWarehouseList();
	}
	@Override
	public List<ItemBean> getItemList(){
		return itemDAO.getItemList();
	}
	@Override
	public List<ItemBean> searchItemList(QueryBean query){
		return itemDAO.searchItemList(query);
	}
	@Override
	public List<BOMBean> searchBOM(String itemCode) {
		// TODO Auto-generated method stub
		return bomDAO.searchBOM(itemCode);
	}
	@Override
	public List<BOMBean> unfoldBOM(String parentItemCode) {
		// TODO Auto-generated method stub
		return  bomDAO.unfoldBOM(parentItemCode);
	}
	@Override
	public void batchWarehouseProcess(List<WarehouseBean> warehouseList) {
		// TODO Auto-generated method stub
		List<CodeBean> codeBeanList = new ArrayList<CodeBean>();
		for (WarehouseBean warehouseBean : warehouseList) {
			CodeBean codeBean = new CodeBean();
			codeBean.setCode(warehouseBean.getWarehouseCode());
			codeBean.setStatus(warehouseBean.getStatus());
			codeBean.setValue(warehouseBean.getWarehouseName());
			codeBean.setCategoryCode("LO-06");
			codeBean.setUseYN(warehouseBean.getUseYn());
			codeBeanList.add(codeBean);
			if (warehouseBean.getStatus().equals("insert")) {
				warehouseDAO.insertWarehouse(warehouseBean);
			} else if (warehouseBean.getStatus().equals("update")) {
				warehouseDAO.updateWarehouse(warehouseBean);
			} else {
				warehouseDAO.deleteWarehouse(warehouseBean);
			}

		}
		baseApplicationService.batchCodeProcess(codeBeanList);

		
	}
	@Override
	public void batchItemGroupProcess(List<CodeBean> itemGroupList) {
		// TODO Auto-generated method stub
		baseApplicationService.batchCodeProcess(itemGroupList);
	}
	@Override
	public void batchItemProcess(List<ItemBean> itemList) {
		// TODO Auto-generated method stub
		List<CodeBean> codeBeanList = new ArrayList<CodeBean>();
		for (ItemBean itemBean : itemList) {
			CodeBean codeBean = new CodeBean();
			codeBean.setCode(itemBean.getItemCode());
			codeBean.setStatus(itemBean.getStatus());
			codeBean.setValue(itemBean.getItemName());
			codeBean.setCategoryCode("LO-01");
			codeBean.setUseYN(itemBean.getUseYn());
			codeBeanList.add(codeBean);
			if (itemBean.getStatus().equals("insert")) {
				itemDAO.insertItem(itemBean);
			} else if (itemBean.getStatus().equals("update")) {
				itemDAO.updateItem(itemBean);
			} else {
				itemDAO.deleteItem(itemBean);
			}

		}
		baseApplicationService.batchCodeProcess(codeBeanList);
	}
	@Override
	public void batchBOMProcess(List<BOMBean> bomList) {
		// TODO Auto-generated method stub
		for(BOMBean bomBean:bomList){
			if(bomBean.getStatus().equals("insert")){
				bomDAO.insertBOM(bomBean);
			}else if(bomBean.getStatus().equals("update")){
				bomDAO.updateBOM(bomBean);
			}else{
				bomDAO.deleteBOM(bomBean);
			}
				
			
		}
		
	}
}
