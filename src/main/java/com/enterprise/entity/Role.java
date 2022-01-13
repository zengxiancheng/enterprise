package com.enterprise.entity;
import java.io.Serializable;
import com.enterprise.entity.page.PageModel;
public class Role extends PageModel implements Serializable{
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 角色名称
	private String roleName;
	//角色代码
	private String roleCode;
	// 创建时间
	private String createTime;
	// 更新时间
	private String updateTime;
	
	private String menuIds;
	
	
	public void clear() {
		roleName = null;
		roleCode = null;
		createTime = null;
		updateTime = null;
		menuIds = null;
	}
	
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
		
	public String getMenuIds() {
		return menuIds;
	}



	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public String toString() {
		return "Role{" +
				", roleName='" + roleName + '\'' +
				", roleCode='" + roleCode + '\'' +
				", createTime='" + createTime + '\'' +
				", createTime='" + createTime + '\'' + 
				'}';
	}
	
	
	
}
