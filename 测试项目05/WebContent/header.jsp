<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css">
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
	<div id="header" style="height:60px">
        <div class="nav_mask">
            <div class="nav_wrapper clear">
                <div class="category">
                    <ul class="ul-left">
                        <li><a href="<%=request.getContextPath()%>/index.jsp"><img id="logo" src="<%=request.getContextPath() %>/img/logo.jpg" alt=""></a></li>
                        <li><a href="<%=request.getContextPath()%>/sports.jsp">体育</a></li>
                        <li><a href="<%=request.getContextPath()%>/music">音乐榜</a></li>
                        <li><a href="<%=request.getContextPath()%>/game.jsp">游戏</a></li>
                        <li><a href="<%=request.getContextPath()%>/bilirank">bili榜</a></li>
                    </ul>
                </div>
                <div class="user">
                    <ul class="ul-left">
                    	<c:choose>
						<c:when test="${empty user }">
                        <li><a href="<%=request.getContextPath() %>/login.jsp">登录</a></li>
                        <li><a href="<%=request.getContextPath() %>/register.jsp">注册</a></li>
                        </c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${user.isAdmin()==true}">
									<li>管理员：<a href="<%=request.getContextPath()%>/admin/admin.jsp">${user.userName}</a></li>
									<li><a href=""><a href="<%=request.getContextPath()%>/logout">退出</a><li>
								</c:when>
								<c:otherwise>
									<li><a href="<%=request.getContextPath()%>/user/setting.jsp"><img id="user-img" alt="用户头像" src="<%=request.getContextPath()%>/img/users/${user.UID}.jpg"></a></li>
									<li><a href=""><a href="<%=request.getContextPath()%>/logout">退出</a><li>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
						</c:choose>  
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>