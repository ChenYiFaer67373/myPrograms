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
function updateNewGame(){
	$.ajax({
		url:"updateNewGame",
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
                <h6>新游管理页面</h6>
                <div>
                    <table class="func-table">
                        <tr>
                            <th class="introduce">功能</th>
                            <th class="content">内容</th>
                            <th class="optation">操作</th>
                        </tr>
                        <tr>
                            <td>更新数据库</td>
                            <td>更新近三个月发售游戏</td>
                            <td><button class="update" onclick="updateNewGame()">点击更新</button></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>