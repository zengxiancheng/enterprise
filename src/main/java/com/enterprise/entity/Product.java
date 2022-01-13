package com.enterprise.entity;

import java.io.Serializable;
import com.enterprise.entity.page.PageModel;
import com.enterprise.util.LoginUserHolder;


// 产品信息表
public class Product extends PageModel implements Serializable {
		
	private String name;	
	private String measureType;	
	private String model;	
    private String rangeButtom;	
	private String rangeCeil;	
	private String unit;	
	private String ip;	
    private String input;	
	private String output;	
	private String gmtCreated;
	private int userId;
	private String modifyUserCode;
	private String modifyUserName;
	private String gmtModified;
	private String isDeleted;
	private String reserved1;
	private String reserved2;
	private String reserved3;
	private String reserved4;
	private String reserved5;
	
	public void clear(){
		name = null;	
		measureType = null;		
		model = null;
		rangeButtom = null;
		rangeCeil = null;
		unit = null;
		ip = null;
		input = null;
		output = null;
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
	
	public Product() {
	    User user= LoginUserHolder.getLoginUser();
	    userId = user.getId();
		modifyUserCode = user.getUsername();
		modifyUserName = user.getNickname();		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasureType() {
		return measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRangeButtom() {
		return rangeButtom;
	}

	public void setRangeButtom(String rangeButtom) {
		this.rangeButtom = rangeButtom;
	}

	public String getRangeCeil() {
		return rangeCeil;
	}

	public void setRangeCeil(String rangeCeil) {
		this.rangeCeil = rangeCeil;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getGmtCreated() {
		return gmtCreated;
	}

	public void setGmtCreated(String gmtCreated) {
		this.gmtCreated = gmtCreated;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return "Product {name=" + name + ", measureType=" + measureType + ", model=" + model + ", rangeButtom="
				+ rangeButtom + ", rangeCeil=" + rangeCeil + ", unit=" + unit + ", ip=" + ip + ", input=" + input
				+ ", output=" + output + ", gmtCreated=" + gmtCreated + ", userId=" + userId + ", modifyUserCode="
				+ modifyUserCode + ", modifyUserName=" + modifyUserName + ", gmtModified=" + gmtModified
				+ ", isDeleted=" + isDeleted + ", reserved1=" + reserved1 + ", reserved2=" + reserved2 + ", reserved3="
				+ reserved3 + ", reserved4=" + reserved4 + ", reserved5=" + reserved5 + "}";
	}
	

}
