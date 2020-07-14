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
// 	function addMusicTopList(){
// 		var listId=$("#listId").val();
// 		var name=$("#name").val();
// 		$.ajax({
// 			url:"addMusicTopList",
// 			type:"post",
// 			dataType:"json",
// 			data:{"listId":listId,"name":name},
// 			success:function(data){
// 				if(data==1){
// 					alert("数据添加成功！");
// 				}else{
// 					alert("添加失败请重新尝试！");
// 				}
// 			}
// 		});
// 	}

$(function(){
	loadBiliCategory();
});
function loadBiliCategory(){
	$.ajax({
		url:"loadMusicTopList",
		type:"post",
		dataType:"json",
		data:"",
		success:function(data){
			str="";
			for(var i=0;i<data.length;i++){
				str+='<tr>'+
                    '<td>'+data[i].listId+'</td>'+
                    '<td>'+data[i].name+'</td>'+
                    '<td>'+data[i].apiUrl+'</td>'+
                    '<td>'+data[i].status+'</td>'+
                    '<td><button class="changebtn" onclick="changeMusicListStatus(this)">修改</button></td>'+
                '</tr>';
			}
			$("#category-title").after(str);
		}
	});
};
function updateMusicTopList(){
	$.ajax({
		url:"updateMusicData",
		type:"post",
		dateType:"json",
		data:"",
		success:function(data){
			if(data==1){
				alert("数据更新成功！");
			}else{
				alert("数据更新失败！");
			}
		}
	});
};
function changeMusicListStatus(a){
	var listId=$(a).parent().prev().prev().prev().prev().text();
	var status=$(a).parent().prev().text();
	$.ajax({
		url:"changeMusicListStatus",
		type:"post",
		dataType:"json",
		data:{"listId":listId,"status":status},
		success:function(data){
			if(data==1){
				$(a).parent().prev().text(data);
			}else{
				$(a).parent().prev().text(data);
			}
		}
	});
}
function addMusicTopList(){
	var listId=$("#listId").val();
	var name=$("#name").val();
	$.ajax({
		url:"addMusicTopList",
		type:"post",
		dataType:"json",
		data:{"listId":listId,"name":name},
		success:function(data){
			if(data==1){
					alert("歌单添加成功！");
					window.location.reload();
				}else{
					alert("已有该歌单请确认Id是否正确！");
				}
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
                <h6>网易云歌单榜管理页面</h6>
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
                            <td><button class="update" onclick="updateMusicTopList()">点击更新</button></td>
                        </tr>
                        <tr>
                            <td>已有分区</td>
                            <td colspan="2" class="category">
                                <table class="category-table">
                                    <tr id="category-title">
                                        <th>歌单Id</th>
                                        <th>歌单名</th>
                                        <th>接口地址</th>
                                        <th>当前状态</th>
                                        <th>下架/上架</th>
                                    </tr>
                                    
                                </table>
                            </td> 
                        </tr>
                        <tr>
                            <td>添加新歌单</td>
                            <td colspan="2" style="text-align:left">
                                <form class="form1">
                                    <div>listId</div><input id="listId" type="text" name="listId" style="width:200px" autocomplete="off"><br>
                                    <div>name</div><input id="name" type="text" name="name" style="width:200px" autocomplete="off"><br>
                                    <input type="button" value="点击添加" onclick="addMusicTopList()">
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