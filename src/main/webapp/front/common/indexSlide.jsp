<%--
  Created by IntelliJ IDEA.
  User: Cesiumai
  Date: 2016/6/16
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8" %>
<link href="<%=path%>/resource/swiper/css/swiper.min.css" rel="stylesheet" type="text/css"/>
<script src="<%=path%>/resource/swiper/js/swiper.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=path%>/resource/swiper/css/font.css">
<link rel="stylesheet" href="<%=path%>/resource/swiper/css/ups.css">
<link rel="stylesheet" href="<%=path%>/resource/swiper/css/zsj.min.css">
<div id="ups-banner">
    <div class="swiper-container">
      <div class="swiper-wrapper">     
      <c:forEach var="item" items="<%=SystemManage.getInstance().getIndexImgs()%>">
        <div class="swiper-slide">
          <div class="content"><div class="txt"><h3>${item.title}</h3><p>${item.topDesc} </p><p>${item.buttomDesc}</p></div><a href="${item.link}" class="link">了解更多</a></div>
          <div class="img-fix"><div class="img-inner"><img src="<%=SystemManage.getInstance().getSystemSetting().getImageRootPath()%>/${item.pictureUrl}" class="img"></div></div>
        </div>
      </c:forEach>
      </div>
      <div class="bottom-nav"><div class="ups-icon-videoplay"></div><div class="swiper-pagination"></div></div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
    </div>
  </div>
<script src="<%=path%>/resource/swiper/js/ups.js"></script>



