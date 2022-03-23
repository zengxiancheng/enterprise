<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/manage/system/IotpageBase.jsp" %>
<%@ page info="项目管理" %>
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

<form action="<%=path%>/manage/project" id="form" method="post">
    <div style="height:auto!important;height:550px;min-height:550px;">
        <h3 style="border-bottom: 1px solid #D7D7D7;color: #666666;font-size: 28px;padding-bottom: 20px;margin-bottom: 30px;">
            <%=getServletInfo()%>
            <a href="<%=path %>/manage/project/selectList" class="btn btn-primary"
               style="padding: 2px 15px;float:right;"><i class="icon-double-angle-left"></i>返回列表</a>
        </h3>
        <table width="100%" border="0" cellspacing="0" cellpadding="10" class="tableBasic">
            <tr style="display:none;">
                <th>id</th>
                <td><input type="hidden" name="id" value="${e.id}"></td>
            </tr>
            <tr>
                <th style="text-align: right;width: 150px">项目编码：</th>
                <td style="text-align: left;">
                    <c:choose>
                        <c:when test="${empty e.seriNo}">
                            <input type="text" name="seriNo" id="seriNo"  size="40"
                                   data-rule="帐号:required;nickname;length[4~20];remote[unique]" >
                        </c:when>
                        <c:otherwise>
                            <strong>${e.seriNo}</strong>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">项目名称：</th>
                <td style="text-align: left;">                    
                      <c:choose>
                        <c:when test="${empty e.name}">
                            <input type="text" name="name" value="${e.name}" id="owner"  size="40"
                                    data-rule="项目名称:required;nickname;length[2~20];remote[unique]"/> 
                        </c:when>
                        <c:otherwise>
                            <strong>${e.name}</strong>
                        </c:otherwise>
                    </c:choose>                                                                                
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">业主名称：</th>
                <td style="text-align: left;">   
                    <input type="text" name="owner" value="${e.owner}" id="owner"  size="40"
                           data-rule="业主名称:required;nickname;length[2~20];"/>
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">项目地址：</th>
                <td style="text-align: left;">   
                    <input type="text" name="addr" value="${e.addr}" id="addr"  size="40"
                           data-rule="项目地址:required;nickname;length[2~40];"/>
                </td>
            </tr>
          
              <tr>
                <th style="text-align: right;">项目联系人：</th>
                <td style="text-align: left;">   
                    <input type="text" name="contactor" value="${e.contactor}" id="contactor"  size="40"
                           data-rule="项目联系人:required;nickname;length[2~20];"/>
                </td>
            </tr>
             <tr>
                <th style="text-align: right;">联系电话：</th>
                <td style="text-align: left;">   
                    <input type="text" name="contactPhone" value="${e.contactPhone}" id="contactPhone"  size="40"
                           data-rule="联系电话:required;mobile;length[2~20];"/>
                </td>
            </tr>
              <tr>
                <th style="text-align: right;">项目基本信息：</th>
                <td style="text-align: left;">   
                    <textarea   name="detailInfo" id="detailInfo" cols="40">${e.detailInfo}</textarea>                   
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