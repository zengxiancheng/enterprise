<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/manage/system/pageBase.jsp" %>
<%@ page info="产品管理" %>
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

<form action="<%=path%>/manage/product" id="form" method="post">
    <div style="height:auto!important;height:550px;min-height:550px;">
        <h3 style="border-bottom: 1px solid #D7D7D7;color: #666666;font-size: 28px;padding-bottom: 20px;margin-bottom: 30px;">
            <%=getServletInfo()%>
            <a href="<%=path %>/manage/product/selectList" class="btn btn-primary"
               style="padding: 2px 15px;float:right;"><i class="icon-double-angle-left"></i>返回列表</a>
        </h3>
        <table width="100%" border="0" cellspacing="0" cellpadding="10" class="tableBasic">
            <tr style="display:none;">
                <th>id</th>
                <td><input type="hidden" name="id" value="${e.id}"></td>
            </tr>
            <tr>
                <th style="text-align: right;width: 150px">产品名称：</th>
                <td style="text-align: left;">
                    <c:choose>
                        <c:when test="${empty e.name}">
                            <input type="text" name="name" id="name"  size="40"
                                   data-rule="产品名称:required;nickname;length[4~20];remote[unique]" >
                        </c:when>
                        <c:otherwise>
                            <strong>${e.name}</strong>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">产品型号：</th>
                <td style="text-align: left;">                  
                    <input type="text" name="model" value="${e.model}" id="model"  size="40"
                           data-rule="产品型号:required;nickname;length[2~20];remote[unique]"/>                                                      
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">测量对象：</th>
                <td style="text-align: left;">                           
                     <select id="measureType" name="measureType" >
                            <option value="流量" selected="selected">流量</option>
                            <option value="流速">流速</option>
                            <option value="压力">压力</option>
                            <option value="温度">温度</option>
                            <option value="物位">物位</option>
                       
                    </select>
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">量程：</th>
                <td style="text-align: left;">   
                    <input type="text" name="rangeButtom" value="${e.rangeButtom}" id="rangeButtom"  size="17"
                           data-rule="最小值:required;realnumber;length[2~40];"/>--
                    <input type="text" name="rangeCeil" value="${e.rangeCeil}" id="rangeCeil"  size="18"
                           data-rule="最大值:required;realnumber;length[2~40];"/>
                </td>
            </tr>
          
              <tr>
                <th style="text-align: right;">测量单位：</th>
                <td style="text-align: left;">                             
                   <select id="unit" name="unit" >
                            <option value="m³/s" selected="selected">m³/s</option>
                            <option value="m/s">m/s</option>
                            <option value="kPa">kPa</option>
                            <option value="℃">℃</option>
                            <option value="m">m</option>
                       
                    </select>
                </td>
            </tr>
             <tr>
                <th style="text-align: right;">输入参数：</th>
                <td style="text-align: left;">   
                    <input type="text" name="input" value="${e.input}" id="input"  size="40"
                           data-rule="输入参数:required;length[2~20];"/>
                </td>
            </tr>
            
            <tr>
                <th style="text-align: right;">输出参数：</th>
                <td style="text-align: left;">   
                    <input type="text" name="output" value="${e.output}" id="output"  size="40"
                           data-rule="输出参数:required;length[2~20];"/>
                </td>
            </tr>
            
              <tr>
                <th style="text-align: right;">防护等级：</th>
                <td style="text-align: left;">                          
                           <select id="ip" name="ip" >
                            <option value="IP65" selected="selected">IP65</option>
                            <option value="IP68">IP68</option>
                            </select>
                </td>
            </tr>
            
              <tr>
                <th style="text-align: right;">注意事项：</th>
                <td style="text-align: left;">   
                    <textarea type="text" name="reserved3" value="${e.reserved3}" id="reserved3" cols="40">
                     </textarea>
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