package com.enterprise.entity;

import java.io.Serializable;
import com.enterprise.entity.page.PageModel;
public class Rolemenu extends PageModel implements Serializable{
	
	private String roleId;
	private String menuId;
	private String gmtModified;	
	public void clear(){
		roleId = null;
		menuId = null;
		gmtModified = null;				
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}
	@Override
	public String toString() {
		return "Rolemenu {roleId=" + roleId + ", menuId=" + menuId + ", gmtModified=" + gmtModified + "}";
	}
	
	

}
