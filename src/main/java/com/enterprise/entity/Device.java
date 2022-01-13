package com.enterprise.entity;

import java.io.Serializable;
import com.enterprise.entity.page.PageModel;
import com.enterprise.util.LoginUserHolder;

//设备信息
public class Device extends PageModel implements Serializable {
	private String name;
	private String seriNo;
	private String seriType;
	private String addr;
	private String location;

	private String rtuNo;
	private String onLine;
	private String collectFre;
	


	private String unit;
	
	private String communicateMode;

	private String realData;
	private int userId;
	private int projectId;
	

	private String gmtCreated;
	private String modifyUserCode;
	private String modifyUserName;
	private String gmtModified;
	private String isDeleted;
	private String reserved1;
	private String reserved2;
	private String reserved3;
	private String reserved4;
	private String reserved5;
	
	 public Device() {
		    User user= LoginUserHolder.getLoginUser();
		    userId = user.getId();
			modifyUserCode = user.getUsername();
			modifyUserName = user.getNickname();		
		}

	public void clear() {
		name = null;
		seriNo = null;
		seriType = null;
		addr = null;
		location = null;

		rtuNo = null;
		onLine = null;
		collectFre = null;
		communicateMode = null;

		realData = null;
		gmtCreated = null;
		modifyUserCode = null;
		modifyUserName = null;
		gmtModified = null;
		isDeleted = null;
		reserved1 = null;
		reserved2 = null;
		reserved3 = null;
		reserved4 = null;
		reserved5 = null;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSeriType() {
		return seriType;
	}

	public void setSeriType(String seriType) {
		this.seriType = seriType;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRtuNo() {
		return rtuNo;
	}

	public void setRtuNo(String rtuNo) {
		this.rtuNo = rtuNo;
	}

	public String getOnLine() {
		return onLine;
	}

	public void setOnLine(String onLine) {
		this.onLine = onLine;
	}

	public String getCollectFre() {
		return collectFre;
	}

	public void setCollectFre(String collectFre) {
		this.collectFre = collectFre;
	}

	public String getCommunicateMode() {
		return communicateMode;
	}

	public void setCommunicateMode(String communicateMode) {
		this.communicateMode = communicateMode;
	}

	public String getRealData() {
		return realData;
	}

	public void setRealData(String realData) {
		this.realData = realData;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(String gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public String getModifyUserCode() {
		return modifyUserCode;
	}

	public void setModifyUserCode(String modifyUserCode) {
		this.modifyUserCode = modifyUserCode;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	public String getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getReserved1() {
		return reserved1;
	}

	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	public String getReserved2() {
		return reserved2;
	}

	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}

	public String getReserved3() {
		return reserved3;
	}

	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}

	public String getReserved4() {
		return reserved4;
	}

	public void setReserved4(String reserved4) {
		this.reserved4 = reserved4;
	}

	public String getReserved5() {
		return reserved5;
	}

	public void setReserved5(String reserved5) {
		this.reserved5 = reserved5;
	}

	@Override
	public String toString() {
		return "Device {name=" + name + ", seriNo=" + seriNo + ", seriType=" + seriType + ", addr=" + addr
				+ ", location=" + location + ", rtuNo=" + rtuNo + ", onLine=" + onLine + ", collectFre=" + collectFre
				+ ", unit=" + unit + ", communicateMode=" + communicateMode + ", realData=" + realData + ", userId="
				+ userId + ", projectId=" + projectId + ", gmtCreated=" + gmtCreated + ", modifyUserCode="
				+ modifyUserCode + ", modifyUserName=" + modifyUserName + ", gmtModified=" + gmtModified
				+ ", isDeleted=" + isDeleted + ", reserved1=" + reserved1 + ", reserved2=" + reserved2 + ", reserved3="
				+ reserved3 + ", reserved4=" + reserved4 + ", reserved5=" + reserved5 + "}";
	}


	
	


}
