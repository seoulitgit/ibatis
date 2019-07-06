package kr.co.seoulit.base.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_menu_authority")
public class MenuAuthorityBean extends BaseBean{
	private String menuCode, authorityCode,menu;

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}
	
}