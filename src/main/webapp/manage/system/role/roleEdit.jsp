<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/manage/system/pageBase.jsp" %>
<%@ page info="角色管理" %>
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

<form action="<%=path%>/manage/role" id="form" method="post">
    <div style="height:auto!important;height:550px;min-height:550px;">
        <h3 style="border-bottom: 1px solid #D7D7D7;color: #666666;font-size: 28px;padding-bottom: 20px;margin-bottom: 30px;">
            <%=getServletInfo()%>
            <a href="<%=path %>/manage/role/selectList" class="btn btn-primary"
               style="padding: 2px 15px;float:right;"><i class="icon-double-angle-left"></i>返回列表</a>
        </h3>
        <table width="100%" border="0" cellspacing="0" cellpadding="10" class="tableBasic">

            <tr style="display:none;">
                <th>id</th>
                <td><input type="hidden" name="id" value="${e.id}"></td>
            </tr>
            <tr>
                <th style="text-align: right;width: 150px">角色名称：</th>
                <td style="text-align: left;">
                    <c:choose>
                        <c:when test="${empty e.roleName}">
                            <input type="text" name="roleName" id="roleName"  size="40"
                                   data-rule="帐号:required;nickname;length[4~20];remote[unique]" >
                        </c:when>
                        <c:otherwise>
                            <strong>${e.roleName}</strong>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">角色代码：</th>
                <td style="text-align: left;">   
                    <input type="text" name="roleCode" value="${e.roleCode}" id="roleCode"  size="40"
                           data-rule="管理员名称:required;username;length[2~20];remote[unique]"/>
                </td>
            </tr>
            <tr>
            <th style="text-align: right;">角色授权：</th>           
		    <td style="text-align: right;">
		    <input type="text" name="menuIds" value="${e.menuIds}" id="menuIds"/>
			<div style="min-width: 200px;">
				<div id="loadImg" style="text-align: center;">
					<img alt="菜单加载中......" src="<%=path %>/resource/images/loader.gif">
				</div>			
				<ul id="treeDemo2" style="display: none;" class="ztree"></ul>
			</div>
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
	// 获取点击的菜单
	 checkMenus()	
	_form.attr("action",$(obj).attr("method"));
	_form.submit();
}

$(function(){
	var setting = {
			check: {
				enable: true,
				dblClickExpand: false,
				chkStyle :"checkbox"
			},callback: {
				onClick: function(e,treeId, treeNode) {
	                var zTree = $.fn.zTree.getZTreeObj("treeDemo2");
	                zTree.expandNode(treeNode);
	            },
				onMouseDown: function (event, treeId, treeNode) {
					console.log(event);
					console.log(">>>"+treeId);
					console.log(">>>"+treeNode);
	                var url = "toAddOrUpdate?id="+treeNode.id;
	                console.log(url);
	                if(true){
	                    $("#iframeMenuEdit").attr("src",url);
	                    return;
	                }
	                //alert(url);
	                $("#dfsfsf").val(treeNode.id);
	                document.form1.action = url;
	                document.form1.submit();
	            },
	            onCheck: function(event, treeId, treeNode){
	            	if(treeNode.checked){
	            		checkMenus();	            		
	            	}
	            	console.log(event);
	            	console.log(">>>"+treeId);
					console.log(">>>"+treeNode.id);
					console.log("查看节点是否选中："+treeNode.checked);   	
	            }  
	            
	            
			},
	        data:{
	            key:{
	                url:"_url"
	            }
	        }
	};

	loadMenusTree();

	//加载菜单树
	function loadMenusTree(){
		$.ajax({
			url:"<%=path%>/manage/menu/getMenusByPid?pid=0",
						type:"post",
						dataType:"text",
						success:function(data, textStatus){
							var zNodes = eval('('+data+')');							
							$.fn.zTree.init($("#treeDemo2"), setting, zNodes);
							$("#loadImg").hide();
							$("#treeDemo2").show();
						},
						error:function(){
							alert("error");
						}
					});
				}
				
				//点击菜单项				
				var expandAllFlg = true;
				function expandNode(e) {
					var zTree = $.fn.zTree.getZTreeObj("treeDemo2"),
					type = e.data.type,
					nodes = zTree.getSelectedNodes();

					if (type == "expandAll") {
						zTree.expandAll(true);
					} else if (type == "collapseAll") {
						zTree.expandAll(false);
					} else if (type == "expandOrCollapse") {
						zTree.expandAll(expandAllFlg);
						expandAllFlg = !expandAllFlg;
					} else {
						if (type.indexOf("All")<0 && nodes.length == 0) {
							alert("请先选择一个父节点");
						}
						var callbackFlag = $("#callbackTrigger").attr("checked");
						for (var i=0, l=nodes.length; i<l; i++) {
							zTree.setting.view.fontCss = {};
							if (type == "expand") {
								zTree.expandNode(nodes[i], true, null, null, callbackFlag);
							} else if (type == "collapse") {
								zTree.expandNode(nodes[i], false, null, null, callbackFlag);
							} else if (type == "toggle") {
								zTree.expandNode(nodes[i], null, null, null, callbackFlag);
							} else if (type == "expandSon") {
								zTree.expandNode(nodes[i], true, true, null, callbackFlag);
							} else if (type == "collapseSon") {
								zTree.expandNode(nodes[i], false, true, null, callbackFlag);
							}
						}
					}
				}
				$("#expandOrCollapseAllBtn").bind("click", {type:"expandOrCollapse"}, expandNode);
			});


//点击check选中
function checkMenus(){
	var ids = "";
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo2");
	var nodes = treeObj.getCheckedNodes(true);
	if(nodes.length==0){
		return false;
	}
	for(var i=0;i<nodes.length;i++){
		ids+=nodes[i].id+",";
	}		
	$("#menuIds").val(ids);
}		
			
			
</script>



<%@ include file="/manage/system/baseFoot.jsp" %>