package kr.co.seoulit.base.to;

import kr.co.seoulit.common.annotation.Dataset;
import kr.co.seoulit.common.to.BaseBean;

@Dataset(name="ds_menu")
public class MenuBean extends BaseBean{
	private String menuCode, parentmenuCode, menu, url,level;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getParentmenuCode() {
		return parentmenuCode;
	}
	public void setParentmenuCode(String parentmenuCode) {
		this.parentmenuCode = parentmenuCode;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}