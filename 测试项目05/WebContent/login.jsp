<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js" ></script>
	<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				verifyLogin();
			});
		});
		function verifyLogin(){
			var username=$("#username").val();
			var password=$("#password").val();
			$.ajax({
				url:"login",
				type:"POST",
				dataType:"json",
				data:{"username":username,"password":password},
				success:function(data){
					var msg=data.msg;
					if(msg=="user"){
						window.location.href="<%=request.getContextPath()%>/index.jsp";
					}else if(msg=="error"){
						alert("账号或密码错误，请重新输入！");
					}else{
						window.location.href="<%=request.getContextPath()%>/admin/admin.jsp";
					}
				}
			});
		};
	</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<div class="login100-form validate-form" id="form" action="#">
					<span class="login100-form-title p-b-49">登录</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
						<span class="label-input100">用户名</span>
						<input class="input100" type="text" name="username" id="username" placeholder="请输入用户名" autocomplete="off">
						<span class="focus-input100" data-symbol=""></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100">密码</span>
						<input class="input100" type="password" name="password" id="password" placeholder="请输入密码">
						<span class="focus-input100" data-symbol="  "></span>
					</div>

					<div class="text-right p-t-8 p-b-31">
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" id="btn">登 录</button>
						</div>
					</div>

					<div class="flex-col-c p-t-25">
						<a href="<%=request.getContextPath() %>/register.jsp" class="txt2">立即注册</a>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>