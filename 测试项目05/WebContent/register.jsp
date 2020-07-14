<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js" ></script>
	<script type="text/javascript">
		$(function(){
			name=false;
			password=false;
			repassword=false;
			$("#userName").blur(function(){
				var userName=$(this).val();
				$.ajax({
					url:"checkUserNameForRegister",
					type:"post",
					dataType:"json",
					data:{"userName":userName},
					success:function(data){
						if(data==true){
							$("#nameMsg").html("");
							
						}else{
							$("#nameMsg").html("X 该用户名已被占用！").css("color","red");
						}
					}
				});
			});
			$("input[name='password']").blur(function(){
				if(!$(this).val().match(/^\w{6,16}$/)){
					if($(this).val()==""){
						$(this).next().html("");
					}else{
						$("#pwdMsg").html("X 密码不符合规范！").css("color","red");
					}
					password=false;
				}else{
					$("#pwdMsg").html("");
					password=true;
				}
			});
			$("input[name='repassword']").blur(function(){
				if($(this).val().match(/^\w{6,16}$/)&&$(this).val()==$("input[name='password']").val()){
					$(this).next().html("");
					repassword=true;
				}else{
					if($(this).val()==""){
						$(this).next().html("");
					}else{
						$(this).next().css("color","red").html("密码不一致请修改!");
					}
					repassword=false;
				}
			});
			
			$("#password,#rePassword").blur(function(){
				if(password==true&&repassword==true&&$("#nameMsg").text()==""){
					$("#register").removeAttr("disabled","disabled");
				}else{
					$("#register").attr("disabled","disabled");
				}
			});
		});
	</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="limiter">
		<div class="container-login100" style="background-image: url(&#39;images/bg-01.jpg&#39;);">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" action="<%=request.getContextPath() %>/register_do" method="post">
					<span class="login100-form-title p-b-49">注册</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
						<span class="label-input100"></span>
						<input id="userName" class="input100" type="text" name="username" placeholder="用户名长度小于12位" autocomplete="off" minLength="4" maxLength="12">
						<span class="focus-input100" data-symbol="" id="nameMsg"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100"></span>
						<input id="password" class="input100" type="password" name="password" placeholder="密码(6-16个字符组成，区分大小写)">
						<span class="focus-input100" data-symbol="" id="pwdMsg"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100"></span>
						<input id="rePassword" class="input100" type="password" name="repassword" placeholder="请确保两次密码一致">
						<span class="focus-input100" data-symbol="" id="repwdMsg"></span>
					</div>

					<div class="text-right p-t-8 p-b-31">
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button id="register" class="login100-form-btn" type="submit" disabled="disabled">注册 </button>
						</div>
					</div>

					<div class="flex-col-c p-t-25">
						<a href="<%=request.getContextPath() %>/login.jsp" class="txt2">已有账号，直接登录></a>
					</div>
				</form>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
<%-- <form action="<%=request.getContextPath() %>/register_do" method="post"> --%>
<!-- 	用户名：<input type="text" name="username"/><br/> -->
<!-- 	输入密码：<input type="password" name="password1" /><br/> -->
<!-- 	确认密码：<input type="password" name="password2" /><br/> -->
<!-- 	性别	：男<input type="radio" name="sex" vlaue="男" checked="checked"> 女 <input type="radio" name="sex" vlaue="女"><br/> -->
<!-- 	电子邮箱：<input type="email" name="email"><br/> -->
<!-- 	<input type="submit" value="点击注册"><br/> -->
<!-- </form> -->
</body>
</html>