<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/basement.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/account.css">
<script type="text/javascript">
	$(function(){
		$(".btn").click(function() {
			$("#msg1,#msg2,#msg3").html("");
			$.ajax({
				type:'POST',
				url:'resetpwd',
				dataType:"json",
				data:$("#form1").serialize(),
				success:function(data){
					if(data==1){
						alert("密码修改成功,请使用新密码登录!");
						window.location.href="<%=request.getContextPath()%>/index.jsp";
					}else if(data==2){
						$("#msg1").html("X 密码错误无法修改！");
					}else if(data==3){
						$("#msg2").html("X 新密码要在6-16位之间");
					}else if(data==4){
						$("#msg3").html("X 两次密码不一致！");
					}else if(data==5){
						$("#msg3").html("X 密码没有发生变化！");
					}
				}
			});
		});
	});
</script>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="security-content">
<div class="security-left">
          <span class="security-title">个人中心</span>
          <ul class="security-ul">
              <li class="security-list">
                  <span class="security-nav-name"><a href="<%=request.getContextPath() %>/user/setting.jsp" id="myinfo">我的信息</a></span>
            </li>
            <li class="security-list">
                    <span class="security-nav-name"><a href="<%=request.getContextPath() %>/user/resetpwd.jsp" id="changepwd">修改密码</a></span>
            </li>
            <li class="security-list">
                    <span class="security-nav-name"><a href="<%=request.getContextPath() %>/user/myphoto.jsp" id="myphoto">我的头像</a></span>
             </li>
         </ul>
     </div>
     <div class="security-right">
         <div class="security-right-title">
             <span class="security-right-title-icon"></span>
             <span class="security-right-title-text">设置你的个人信息</span>
         </div>
		 <div id="div2" class="user-setting-warp">
             <div>
                 <form class="el-form" id="form1">
                         <div class="el-form-item">
                             <label class="el-form-item__label" for="username">请输入当前密码：</label>
                             <input class="el-input" autocomplete="off" type="password" id="password" name="password" maxlength="16" >
                             <span style="color:red" id="msg1"></span>
                         </div>
                         <div class="el-form-item">
                                 <label class="el-form-item__label" for="npwd">请输入新密码：</label>
                                 <input class="el-input" autocomplete="off" type="password" id="npwd" name="newPassword" maxlength="16">
                                 <span style="color:red" id="msg2"></span>
                         </div>
                         <div class="el-form-item">
                                 <label class="el-form-item__label" for="npwd">请确认新密码：</label>
                                 <input class="el-input" autocomplete="off" type="password" id="npwd" name="rePassword" maxlength="16">
                                 <span style="color:red" id="msg3"></span>
                         </div>
                         <div class="el-form-item">
                         <div class="padding_dom"></div>
                         <div class="mybtn">
                             <a class="btn">
                                 <span>修改</span>
                             </a>
                         </div>
                     </div>
                 </form>
             </div>
         </div>            
     </div>
 </div>
</body>
<jsp:include page="/footer.jsp"></jsp:include>
</html>