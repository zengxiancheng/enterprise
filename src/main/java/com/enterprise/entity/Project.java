package com.enterprise.entity;

import java.io.Serializable;

import com.enterprise.entity.page.PageModel;
import com.enterprise.util.LoginUserHolder;

//项目信息
public class Project extends PageModel implements Serializable {
	private String seriNo;
	private String name;
	private String owner;
	private String addr;
	private String detailInfo;
	private String contactor;
	private String contactPhone;
	private int userId;

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
	
   public Project() {
	    User user= LoginUserHolder.getLoginUser();
	    userId = user.getId();
		modifyUserCode = user.getUsername();
		modifyUserName = user.getNickname();		
	}


	public void clear() {
		seriNo = null;
		name = null;
		owner = null;
		addr = null;
		detailInfo = null;
		contactPhone = null;
		gmtCreated = null;
		modifyUserCode = null;
		modifyUserName = null;
		gmtModified = null;
		contactor = null;
		isDeleted = null;
		reserved1 = null;
		reserved2 = null;
		reserved3 = null;
		reserved4 = null;
		reserved5 = null;
	}

	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}

	public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
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
		return "Project {seriNo=" + seriNo + ", name=" + name + ", owner=" + owner + ", addr=" + addr + ", detailInfo="
				+ detailInfo + ", contactor=" + contactor + ", contactPhone=" + contactPhone + ", userId=" + userId
				+ ", gmtCreated=" + gmtCreated + ", modifyUserCode=" + modifyUserCode + ", modifyUserName="
				+ modifyUserName + ", gmtModified=" + gmtModified + ", isDeleted=" + isDeleted + ", reserved1="
				+ reserved1 + ", reserved2=" + reserved2 + ", reserved3=" + reserved3 + ", reserved4=" + reserved4
				+ ", reserved5=" + reserved5 + "}";
	}

}
