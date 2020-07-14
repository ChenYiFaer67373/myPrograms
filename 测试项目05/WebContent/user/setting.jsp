<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息中心</title>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/basement.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/account.css">
<script type="text/javascript">
	$(function(){
		$("#username").blur(function(){
			if($(this).val()==null||$(this).val()==""){
				$("#nameMsg").html("X 用户名不能为空").css("color","red");
				$(".btn").attr("disabled","disabled").css("background","none");
			}else{
				checkUserName();
			}
		});
		$("#email").change(function(){
			var email=$(this).val();
			if(email!=null&&email!=""){
				var regx=/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
				if(regx.test(email)){
					$("#emailMsg").html("√ 邮箱格式正确").css("color","green");
					$(".btn").removeAttr("disabled","disabled");
				}else{
					$("#emailMsg").html("X 邮箱格式错误").css("color","red");
					$(".btn").attr("disabled","disabled");
				}
			}
		});
		$(".btn").click(function(){
			updateInfo();
		});
	});

function checkUserName(){
	var userName=$("#username").val();
	$.ajax({
		url:"<%=request.getContextPath()%>/checkUserName",
		type:"post",
		data:{"userName":userName},
		dataType:"json",
		success:function(data){
			if(data==true){
				$("#nameMsg").html("√ 用户名可用").css("color","green");
				$(".btn").removeAttr("disabled","disabled");
				b=true;
			}else{
				$("#nameMsg").html("X 用户名已存在").css("color","red");
				$(".btn").attr("disabled","disabled");
				b=false;
			}
		}
	});
}

function updateInfo(){
	var form=$("#form1").serialize();
	$.ajax({
		url:'updateInfo',
		type:'POST',
		dataType:'json',
		data:$("#form1").serialize(),
		success:function(data){
			alert("修改成功！");
			window.location.reload();
		},error:function(data){
			alert("error");
		}
	});
}
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
           <div class="user-setting-warp" id="div1">
               <div>
                   <form class="el-form" id="form1">
                       <div class="el-form-item">
                           <label class="el-form-item__label" for="username">用户名：</label>
                           <input class="el-input" autocomplete="off" type="text" id="username" maxlength="12" name="username" value="${user.userName}">
                           <span style="color:#aaa" id="nameMsg">注：不能使用已注册的用户名</span>
                       </div>
                       <div class="el-form-item">
                               <label class="el-form-item__label" for="uid">UID：</label>
                               <div class="el-input" id="uid">${user.UID }</div>
                               <span style="color:#aaa">注：每个用户的ID是唯一的</span>
                       </div>
                       <div class="el-form-item">
                               <label class="el-form-item__label" for="age">年龄：</label>
                               <input class="el-input" name="age" id="age" type="number" value="${user.age }">
                       </div>
                       <div class="el-form-item">
                               <label class="el-form-item__label">性别：</label>
                               男<input type="radio" name="sex"  checked value="1">&nbsp;&nbsp;
                               女<input type="radio" name="sex" value="0">
                       </div>
                       <div class="el-form-item">
                               <label class="el-form-item__label" for="email">电子邮箱：</label>
                               <input class="el-input" name="email" id="email" type="email" value=${user.email }>
                               <span style="color:#aaa" id="emailMsg">请输入联系邮箱</span>
                       </div>
                       <div class="el-form-item">
                           <div class="padding_dom"></div>
                           <div class="mybtn">
                               <a class="btn">
                                   <span>保存</span>
                               </a>
                           </div>
                       </div>
                   </form>
               </div>
           </div>
       </div>
   </div>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>