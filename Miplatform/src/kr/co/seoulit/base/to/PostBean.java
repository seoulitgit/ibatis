package kr.co.seoulit.base.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_post")
public class PostBean extends BaseBean{
	
	private String sido, sigungu, dong, ri, zipno, sidoName, roadName, buildingcode1, buildingcode2;
	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	private String sigunguCode,sigunguName,sidoCode;

	public String getSido() {
		return sido;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getSigunguCode() {
		return sigunguCode;
	}

	public void setSigunguCode(String sigunguCode) {
		this.sigunguCode = sigunguCode;
	}

	public String getSigunguName() {
		return sigunguName;
	}

	public void setSigunguName(String sigunguName) {
		this.sigunguName = sigunguName;
	}

	public String getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getRi() {
		return ri;
	}

	public void setRi(String ri) {
		this.ri = ri;
	}

	public String getZipno() {
		return zipno;
	}

	public void setZipno(String zipno) {
		this.zipno = zipno;
	}

	public String getBuildingcode1() {
		return buildingcode1;
	}

	public void setBuildingcode1(String buildingcode1) {
		this.buildingcode1 = buildingcode1;
	}

	public String getBuildingcode2() {
		return buildingcode2;
	}

	public void setBuildingcode2(String buildingcode2) {
		this.buildingcode2 = buildingcode2;
	}
}
