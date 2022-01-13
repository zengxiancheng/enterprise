package com.enterprise.entity;

import com.enterprise.entity.page.PageModel;

import java.io.Serializable;

/**
 * 门户滚动图片实体类
 * Created by Cesiumai on 2016/5/27.
 */
public class IndexImg extends PageModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;       //图片标题
    private String pictureUrl;  //图片地址
    private String link;        //跳转链接
    private int orders;      //排序
    private String status;      //状态
    
    // 图片上部描述
    private String topDesc;
    // 图片下部描述
    private String buttomDesc;
    
    @Override
    public void clean() {
        super.clean();
        title = null;
        pictureUrl = null;
        link = null;
        orders = 0;
        status = null;
        topDesc = null;
        buttomDesc = null;
    }

    public String getTitle() {
        return title;
    }
  
    public void setTitle(String title) {
        this.title = title;
    }
    
    

    public String getTopDesc() {
		return topDesc;
	}

	public void setTopDesc(String topDesc) {
		this.topDesc = topDesc;
	}

	public String getButtomDesc() {
		return buttomDesc;
	}

	public void setButtomDesc(String buttomDesc) {
		this.buttomDesc = buttomDesc;
	}

	public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
