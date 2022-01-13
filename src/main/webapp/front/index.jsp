<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="/front/common/common.jsp" %>
<style>
    .banners{
        padding: 80px 0px 80px;width: 1240px;margin:5px auto;
    }
    .banners_li {
        width: 33.33%;
        text-align: left;
    }
    .banners ul li {
        box-sizing: border-box;
        float: left;

    }
    .banners_li a {
        display: block;
        text-align: center;
        border-right: 1px solid #E1E1E1;
    }
    a{
        text-decoration: none;
        color: #000000;
    }
    .banners_li a div {
        display: inline-block;
        cursor: pointer;
        zoom: 1;
    }
    .banners_li a h3 {
        font-size: 20px;
        color: #333333;
        line-height: 28px;
        text-align: left;
        cursor: pointer;
    }
    .banners_li a p {
        font-size: 14px;
        color: #939393;
        line-height: 28px;
        text-align: left;
        cursor: pointer;
    }
    .banners_li_last a {
        border-right: none;
    }
</style>

<body>
<%@include file="/front/common/navigation.jsp" %>
<%@include file="/front/common/indexSlide.jsp" %>
<%-- <div class="banners" >
    <ul>
          <li class="banners_li banners_li_last">
            <a href="<%=path%>/about">
                <div>
                    <h3>关于我们</h3>
                    <p>了解我们，了解益捷</p>
                </div>
            </a>
        </li>
        
         <li class="banners_li">
            <a href="<%=path%>/article">
                <div>
                    <h3>产品中心</h3>
                    <p>公司动态，行业新闻</p>
                </div>
            </a>
        </li>
        
        <li class="banners_li">
            <a href="<%=path%>/service">
                <div>
                    <h3>服务领域</h3>
                    <p>水文水利，石油化工</p>
                </div>
            </a>
        </li>
       
       
    </ul>
</div> --%>

<div class="index-prod-title">PRODUCT CENTER</div>
<div class="index-prod-lanxian"></div>
                 
<c:forEach var="item" items="<%=SystemManage.getInstance().getArticleCategory()%>">            
<div class="center">
   <div class="index-prod-title1">${item.catename}</div>     
   <c:forEach var="article" items="<%=SystemManage.getInstance().getArticle()%>">  
   <div class="index-prod-text clearfloat">
   <ul>     
   <c:if test="${article.categoryId eq item.id}">
     <a href="<%=path%>/article/${article.id}">
                <li class="index-jianju">
                    <img src="<%=SystemManage.getInstance().getSystemSetting().getImageRootPath()%>/${article.image}" alt="${article.title}" width="264" height="264">
                    <div class="index-prod-biaoti">${article.title}</div>
                </li>
            </a>  
    </c:if>                              
     </ul>
    </div>
    </c:forEach>   
    <div class="index-gengduo"><a href="<%=path%>/article/${item.code}"><div class="index-zuo"></div>更多产品<div class="index-you"></div></a></div>
</div>
</c:forEach>
<%@include file="/front/common/foot.jsp" %>

