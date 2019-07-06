package kr.co.seoulit.logistics.base.dao;

import java.util.List;

import kr.co.seoulit.logistics.base.to.WarehouseBean;


public interface WarehouseDAO {
	List<WarehouseBean> getWarehouseList();
	void updateWarehouse(WarehouseBean warehouseBean);
	void deleteWarehouse(WarehouseBean warehouseBean);
	void insertWarehouse(WarehouseBean warehouseBean);
	}