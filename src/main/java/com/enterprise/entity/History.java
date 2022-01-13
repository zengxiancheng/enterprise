package com.enterprise.entity;

import com.enterprise.entity.page.PageModel;
import com.enterprise.util.LoginUserHolder;

import java.io.Serializable;

/**
 * 历史数据
 * Created by 
 */
public class History extends PageModel implements Serializable{
    private static final long serialVersionUID = 1L;
    private String value;
    
    private String type;
    private int userId;
    private String unit;
    private String gmtCreated;
    private String deviceSerino;
    private String isDeleted;

    @Override
    public void clean() {
        super.clean();
        type = null;
        userId = 0;
        unit = null;
        value = null;
        gmtCreated = null;
        deviceSerino = null;
        isDeleted = null;
    }

    
    public History() {
	    User user= LoginUserHolder.getLoginUser();
	    userId = user.getId();
			
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(String gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public String getDeviceSerino() {
		return deviceSerino;
	}

	public void setDeviceSerino(String deviceSerino) {
		this.deviceSerino = deviceSerino;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "History {value=" + value + ", type=" + type + ", userId=" + userId + ", unit=" + unit + ", gmtCreated="
				+ gmtCreated + ", deviceSerino=" + deviceSerino + ", isDeleted=" + isDeleted + "}";
	}

	
	
	
    
    

   
}
