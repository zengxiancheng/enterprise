<%--
  Created by IntelliJ IDEA.
  User: Cesiumai
  Date: 2016/6/15
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8" %>
<style>

    .nav{
        list-style: none outside none;
    }
    .nav li {
        width: 77px;
        height: 107px;
        float: left;
        line-height: 107px;
        font-size: 17px;
        color: #262626;
        margin-left: 16px;
        margin-right: 16px;
        text-align: center;
    }  
       
   /*  .nav li a {
        text-decoration: none;
        color: inherit;
        padding-top: 10px;
        font-family: Microsoft Yahei;
    } */
    .nav li a {
        text-decoration: none;
        color: inherit;
        padding: 3px;
        font-family: Microsoft Yahei;
    } 

  /*   .nav li a:hover{
        border-top: 3px solid #424C55;

    } */
    .nav li a:hover{
       background: #7FA7D8;
       text-decoration: none;

    }
</style>
<div style="width:100%;height:90px;margin: 0 auto;">
    <div style="width:20%; height: 90px;float: left;">
        <a href="index">
        <img src="<%=SystemManage.getInstance().getSystemSetting().getImageRootPath() %><%=SystemManage.getInstance().getSystemSetting().getLogo() %>"
             width="90px" height="90px" style="padding-left:170px"/>
            </a>
    </div>
    <div style="width:80%;height:90px;float:right;overflow: hidden">
        <ul class="nav">
            <li>
                <a href="<%=path%>/index">首 页</a>
            </li>
            <li>
                <a href="<%=path%>/about">关于我们</a>
            </li>
            <li>
                <a href="<%=path%>/article">产品中心</a>
            </li>
            <li>
                <a href="<%=path%>/service">解决方案</a>
            </li>
            
            <li>
                <a href="<%=path%>/recruitment">诚聘英才</a>
            </li>
            <li>
                <a href="<%=path%>/message">在线留言</a>
            </li>
           
            <li>
                <a href="<%=path%>/contact">联系我们</a>
            </li>
             <li>
                <a href="<%=path%>/manage/user/login">益捷云</a>
            </li>
        </ul>
    </div>
</div>