package kr.co.seoulit.logistics.base.dao;

import java.util.List;

import kr.co.seoulit.base.to.CodeBean;
import kr.co.seoulit.logistics.base.to.WarehouseBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class WarehouseDAOImpl extends SqlMapClientDaoSupport implements WarehouseDAO {
	 

	@Override
	public List<WarehouseBean> getWarehouseList(){
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Warehouse.getWarehouseList");
		

	}	

	public void insertWarehouse(WarehouseBean warehouseBean){
		getSqlMapClientTemplate().insert("Warehouse.insertWarehouse",warehouseBean);

	}
	public void deleteWarehouse(WarehouseBean warehouseBean){
		getSqlMapClientTemplate().delete("Warehouse.deleteWarehouse",warehouseBean);

	}
	public void updateWarehouse(WarehouseBean warehouseBean){
		getSqlMapClientTemplate().update("Warehouse.updateWarehouse",warehouseBean);

	}
}
