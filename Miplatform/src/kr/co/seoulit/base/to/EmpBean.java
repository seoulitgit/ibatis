package kr.co.seoulit.base.to;

import java.util.List;

import kr.co.seoulit.common.annotation.Column;
import kr.co.seoulit.common.annotation.Composite;
import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.annotation.Remove;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_emp")
public class EmpBean extends BaseBean{
String empNo,empName,empPw,deptCode,empZipcode,empAddress,authorityCode,imageFile,authorityName;
String useYn;
public String getUseYn() {
	return useYn;
}
public void setUseYn(String useYn) {
	this.useYn = useYn;
}
public String getAuthorityName() {
	return authorityName;
}
public void setAuthorityName(String authorityName) {
	this.authorityName = authorityName;
}

List<DeptBean> dept;

public String getEmpNo() {
	return empNo;
}
@Remove
public List<DeptBean> getDept() {
	return dept;
}
@Composite(bean=DeptBean.class)
public void setDept(List<DeptBean> dept) {
	this.dept = dept;
}

public void setEmpNo(String empNo) {
	this.empNo = empNo;
}

public String getImageFile() {
	return imageFile;
}

public void setImageFile(String imageFile) {
	this.imageFile = imageFile;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getEmpPw() {
	return empPw;
}

public void setEmpPw(String empPw) {
	this.empPw = empPw;
}

public String getDeptCode() {
	return deptCode;
}

public void setDeptCode(String deptCode) {
	this.deptCode = deptCode;
}

public String getEmpZipcode() {
	return empZipcode;
}

public void setEmpZipcode(String empZipcode) {
	this.empZipcode = empZipcode;
}

public String getEmpAddress() {
	return empAddress;
}

public void setEmpAddress(String empAddress) {
	this.empAddress = empAddress;
}

public String getAuthorityCode() {
	return authorityCode;
}

public void setAuthorityCode(String authorityCode) {
	this.authorityCode = authorityCode;
}

}