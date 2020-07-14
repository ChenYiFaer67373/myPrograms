<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理中心</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<link >
<script type="text/javascript">
$(function(){
	loadBiliCategory();
});
function loadBiliCategory(){
	$.ajax({
		url:"loadBiliCategory",
		type:"post",
		dataType:"json",
		data:"",
		success:function(data){
			str="";
			for(var i=0;i<data.length;i++){
				str+='<tr>'+
                    '<td>'+data[i].categoryName+'</td>'+
                    '<td>'+data[i].categoryId+'</td>'+
                    '<td>'+data[i].categoryUrl+'</td>'+
                    '<td>'+data[i].status+'</td>'+
                    '<td><button class="changebtn" onclick="changeCategoryStatus(this)">修改</button></td>'+
                '</tr>';
			}
			$("#category-title").after(str);
		}
	});
};
function updateBiliRank(){
	$.ajax({
		url:"updateBiliData",
		type:"post",
		dateType:"json",
		data:"",
		success:function(data){
			alert("数据更新成功！");
		}
	});
};
function changeCategoryStatus(a){
	var categoryId=$(a).parent().prev().prev().prev().text();
	var status=$(a).parent().prev().text();
	$.ajax({
		url:"changeBiliCategoryStatus",
		type:"post",
		dataType:"json",
		data:{"categoryId":categoryId,"status":status},
		success:function(data){
			if(data==1){
				$(a).parent().prev().text(data);
			}else{
				$(a).parent().prev().text(data);
			}
		}
	});
}
function addNewCategory(){
	var categoryId=$("#categoryId").val();
	var categoryName=$("#categoryName").val();
	var categoryUrl=$("#categoryUrl").val();
	$.ajax({
		url:"addNewCategory",
		type:"post",
		dataType:"json",
		data:{"categoryId":categoryId,"categoryName":categoryName,"categoryUrl":categoryUrl},
		success:function(data){
			alert("添加成功！");
			window.location.reload();
		},
		error:function(data){
			alert("添加失败");
		}
	});
}
</script>
</head>
<body>
 <div class="head">
 <a href="<%=request.getContextPath()%>/index.jsp"><img id="logo" src="<%=request.getContextPath() %>/img/logo.jpg" alt=""></a>
        <div class="head-wrapper">
            <span class="title">聚乐信息聚合平台后台管理系统</span>
            <span class="user">欢迎你：${user.userName}</span>
        </div>
    </div>
    <div class="body clear">
        <div class="body-left">
            <div class="nav-wrapper">
                <ul class="manage">
                    <li><a href="biliRank">bili排行榜</a></li>
                    <li><a href="music">网易云歌单</a></li>
                    <li><a href="newGame">新游管理</a></li>
                    <li><a href="">nba</a></li>
                </ul>
            </div>
        </div>
        <div class="body-right">
            <div class="content-wrapper">
                <h6>bili排行榜管理页面</h6>
                <div>
                    <table class="func-table">
                        <tr>
                            <th class="introduce">功能</th>
                            <th class="content">内容</th>
                            <th class="optation">操作</th>
                        </tr>
                        <tr>
                            <td>更新数据库</td>
                            <td></td>
                            <td><button class="update" onclick="updateBiliRank()">点击更新</button></td>
                        </tr>
                        <tr>
                            <td>已有分区</td>
                            <td colspan="2" class="category">
                                <table class="category-table">
                                    <tr id="category-title">
                                        <th>分区Id</th>
                                        <th>分区名</th>
                                        <th>分区地址</th>
                                        <th>当前状态</th>
                                        <th>下架/上架</th>
                                    </tr>
                                    
                                </table>
                            </td> 
                        </tr>
                        <tr>
                            <td>添加新分区</td>
                            <td colspan="2" style="text-align:left">
                                <form class="form1">
                                    <div>categoryId</div><input id="categoryId" type="text" name="categoryId" style="width:400px" autocomplete="off"><br>
                                    <div>categoryName</div><input id="categoryName" type="text" name="categoryName" style="width:400px" autocomplete="off"><br>
                                    <div>categoryUrl</div><input id="categoryUrl" type="text" name="categoryUrl" style="width:400px" autocomplete="off">
                                    <input type="button" value="点击添加" onclick="addNewCategory()">
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
      <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>