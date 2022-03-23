<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/manage/system/IotpageBase.jsp" %>
<%@ page info="实时数据" %>
<form action="<%=path%>/manage/realData" method="post">
    <div style="height:auto!important;height:550px;min-height:550px;">
        <h3 style="border-bottom: 1px solid #D7D7D7;color: #666666;font-size: 28px;padding-bottom: 20px;margin-bottom: 30px;">
            <%=getServletInfo()%>
            <a href="toAdd" class="btn btn-primary"
               style="padding: 2px 15px;float:right;">
                <i class="icon-plus "></i>添加设备
            </a>
        </h3>
        <div class="filter">
            <button method="deletes" class="btn btn-danger" style="padding:0px 5px;margin-top: -4px;" onclick="return submitIDs(this,'确定删除选择的信息?');">
                <i class="icon-trash"></i>删除
            </button>
        </div>


        <table class="table table-bordered table-hover table-striped">
            <tr >
                <th width="20"><input type="checkbox" id="firstCheckbox"/></th>
                <th>设备编号</th>
                <th>设备名称</th>
                <th>在线状态</th>
                <th>实时数据</th>
                <th>实时位置</th>               
                <th>最新上传时间</th>
                <th nowrap="nowrap">操作</th>
            </tr>
            <c:forEach var="item" items="${pager.list}">
                <tr>
                    <td><input type="checkbox" name="ids"
                               value="${item.id}"/></td>
                    <td>${item.seriNo}</td>
                    <td>${item.name}</td>                    
                    <c:choose>
                     <c:when test="${'1' eq item.onLine }"> 
                      <td>在线</td>
                      <td>${item.realData}-${item.unit}</td>      
                      </c:when>
                     <c:otherwise>
                     <td>离线</td>
                     <td> </td> 
                     </c:otherwise>
                    </c:choose>
                    <td>${item.location}</td>                   
                    <td>${item.gmtModified}</td>
                    <td><a href="toEdit?id=${item.id}">编辑</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="71" style="text-align: center;">
                    <%@ include file="/manage/system/page.jsp" %>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        $("#firstCheckbox").on("click", function () {
            if ($(this).prop("checked")) {
                $("input[type=checkbox]").prop("checked", true);
            } else {
                $("input[type=checkbox]").prop("checked", false);
            }
        });
    });
    function submitIDs(obj, tip) {
        if ($("input:checked").size() == 0) {
            alert("请先选择要操作的内容！");
            return false;
        }

        if (confirm(tip)) {
            //createMark();
            var _form = $("form");
            _form.attr("action", $(obj).attr("method"));
            _form.submit();
        }
        return false;
    }
    //查询
    function selectList(obj) {

        var _form = $("form");
        _form.attr("action", $(obj).attr("method"));
        _form.submit();
    }
</script>
<%@ include file="/manage/system/baseFoot.jsp" %>