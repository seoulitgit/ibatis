package kr.co.seoulit.base.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_dept")
public class DeptBean extends BaseBean{
String deptCode,deptName,deptheadNo;

public String getDeptCode() {
	return deptCode;
}

public void setDeptCode(String deptCode) {
	this.deptCode = deptCode;
}

public String getDeptName() {
	return deptName;
}

public void setDeptName(String deptName) {
	this.deptName = deptName;
}

public String getDeptheadNo() {
	return deptheadNo;
}

public void setDeptheadNo(String deptheadNo) {
	this.deptheadNo = deptheadNo;
}
}