<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/manage/system/IotpageBase.jsp" %>
<%@ page info="设备管理" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    input[type=radio] {
        margin: 0;
        width: 0px !important;
    }

    .jc-demo-box {
        text-align: left;
        background: white;
        border: 1px #bbb solid;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        border-radius: 4px;
        -webkit-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.25);
        -moz-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.25);
        box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.25);
        padding: 1em 2em 2em;
    }

    .page-header {
        margin-top: 4px;
        padding-bottom: 0;
        margin-left: -12px;
        margin-right: -12px;
        margin: 20px 0 30px;
    }

    #preview-pane .preview-container {
        width: 170px;
        height: 170px;
        overflow: hidden;
    }

    .jcrop-holder #preview-pane {
        display: block;
        position: absolute;
        z-index: 2000;
        top: 10px;
        right: -280px;
        padding: 6px;
        border: 1px rgba(0, 0, 0, .4) solid;
        background-color: white;

        -webkit-border-radius: 6px;
        -moz-border-radius: 6px;
        border-radius: 6px;

        -webkit-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
        -moz-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
        box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
    }

    #preview-pane .preview-container {
        width: 170px;
        height: 170px;
        overflow: hidden;
    }

    .a-upload {
        padding: 4px 10px;
        height: 30px;
        line-height: 20px;
        position: relative;
        cursor: pointer;
        color: #888;
        background: #fafafa;
        border: 1px solid #ddd;
        border-radius: 4px;
        overflow: hidden;
        display: inline-block;
        *display: inline;
        *zoom: 1
    }

    .a-upload input {
        position: absolute;
        font-size: 100px;
        right: 0;
        top: 0;
        opacity: 0;
        filter: alpha(opacity=0);
        cursor: pointer
    }

    .a-upload:hover {
        color: #444;
        background: #eee;
        border-color: #ccc;
        text-decoration: none
    }

</style>

<form action="<%=path%>/manage/history" id="form" method="post">
    <div style="height:auto!important;height:550px;min-height:550px;">
        <h3 style="border-bottom: 1px solid #D7D7D7;color: #666666;font-size: 28px;padding-bottom: 20px;margin-bottom: 30px;">
            <%=getServletInfo()%>
            <a href="<%=path %>/manage/device/selectList" class="btn btn-primary"
               style="padding: 2px 15px;float:right;"><i class="icon-double-angle-left"></i>返回列表</a>
        </h3>
        <table width="100%" border="0" cellspacing="0" cellpadding="10" class="tableBasic">

            <tr style="display:none;">
                <th>id</th>
                <td><input type="hidden" name="id" value="${e.id}"></td>
            </tr>
            <tr>
                <th style="text-align: right;width: 150px">设备编号：</th>
                <td style="text-align: left;">
                    <c:choose>
                        <c:when test="${empty e.seriNo}">
                            <input type="text" name="seriNo" id="seriNo"  size="40"
                                   data-rule="设备编号:required;nickname;length[4~20];remote[unique]" >
                        </c:when>
                        <c:otherwise>
                            <strong>${e.seriNo}</strong>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">设备名称：</th>
                <td style="text-align: left;">                             
                    <select id="name" name="name" >
                        <c:forEach var="item" items="${products}">
                            <option value="${item.name}" <c:if test="${e.name eq item.name}">selected="selected" </c:if>>${item.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            
             <tr>
                <th style="text-align: right;">所属项目：</th>
                <td style="text-align: left;">
                    <select id="projectId" name="projectId" >
                        <c:forEach var="item" items="${projects}">
                            <option value="${item.id}" <c:if test="${e.projectId eq item.id}">selected="selected" </c:if>>${item.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            
              <tr>
                <th style="text-align: right;">测量类型：</th>
                <td style="text-align: left;">                              
                    <select id="seriType" name="seriType" >
                        <c:forEach var="item" items="${products}">
                            <option value="${item.measureType}" <c:if test="${e.seriType eq item.measureType}">selected="selected" </c:if>>${item.measureType}</option>
                        </c:forEach>
                    </select>                    
                </td>
            </tr>
              <tr>
                <th style="text-align: right;">安装地址：</th>
                <td style="text-align: left;">   
                    <input type="text" name="addr" value="${e.addr}" id="addr"  size="40"
                           data-rule="安装地址:required;length[2~30]"/>
                </td>
            </tr>
              <tr>
                <th style="text-align: right;">定位信息：</th>
                <td style="text-align: left;">   
                    <input type="text" name="location" value="${e.location}" id="location"  size="40"/>
                </td>
            </tr>
              <tr>
                <th style="text-align: right;">RTU编号：</th>
                <td style="text-align: left;">   
                    <input type="text" name="rtuNo" value="${e.rtuNo}" id="rtuNo"  size="40"/>
                </td>
            </tr>
              <tr>
                <th style="text-align: right;">通讯协议：</th>
                <td style="text-align: left;">                                                
                   <select id="communicateMode" name="communicateMode" >
                            <option value="HTTP" selected="selected">HTTP</option>
                            <option value="MQTT">MQTT</option>
                            <option value="COAP">COAP</option>                                             
                    </select>                                                             
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                   <c:choose>
						<c:when test="${e.id!=0}">
							<button method="update" onclick="commit(this)" class="btn btn-info" style="padding:2px 15px;">
	                                                                    保存
	                        </button>
						</c:when>
						<c:otherwise>
							<button method="insert" onclick="commit(this)" class="btn btn-info" style="padding:2px 15px;">
                            	新增
                        </button>
						</c:otherwise>
					</c:choose>
                </td>
            </tr>
        </table>
    </div>
</form>

<script type="text/javascript">
function commit(obj){	
	var _form = $("form");
	_form.attr("action",$(obj).attr("method"));
	_form.submit();
}
</script>
<%@ include file="/manage/system/baseFoot.jsp" %>