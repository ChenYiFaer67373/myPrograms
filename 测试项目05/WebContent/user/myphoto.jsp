<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>修改密码</title>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/basement.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/account.css">
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
           			<div id="div3" class="user-setting-warp">              
                <div class="clear">
                    <div class="pic-warp" >
                    <img id="mypic" src="<%=request.getContextPath()%>/img/users/${user.UID}.jpg" alt="">
                    <p>当前头像</p>
                    </div>
                    <form id="form1" method="post" action="updatepic" enctype="multipart/form-data">
                        <div class="pic-warp">
                                <input type="file" name="newPic" id="picfile" accept="image/*">
                        </div>
                        <div class="el-form-item">
                             <div class="padding_dom"></div>
                           	<div class="mybtn">
                                 <a class="btn" id="update" onclick="submitXML()">
                                     <span>更新</span>
                                 </a>
                    	    </div>
                        </div>
                    </form>
                </div>
            </div>
       </div>
   </div>
<jsp:include page="/footer.jsp"></jsp:include>

<script type="text/javascript">
function submitXML() {
	var file=$("#picfile").get(0).files[0];
	if(file){
		$("#form1").submit();
	}else{
		alert("请添加图片");
	}
}

function changePhoto(){
	$.ajax({
		url:"updatepic",
		type:"post",
		dataType:"json",
		data:$("#form1").serialize(),
		success:function(data){
			alert("头像修改成功！");
			window.location.reload();
		}
	});
}
</script>
</body>
</html>