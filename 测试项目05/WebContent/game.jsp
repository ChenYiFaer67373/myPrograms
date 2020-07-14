<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B站排行榜</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/basement.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/game.css">

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<style type="text/css">
#toTop{position: fixed;	right:80px;	bottom: 100px;	cursor: pointer;display: none;}
#toTop:hover{content: url("<%=request.getContextPath()%>/img/toTop-hover.png");}
a.title{color:#00a1d6}
a.title:hover{color:yellowgreen}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="min-height:1000px">
<div class="table-list">
        <div class="wrapper clear">
        </div>
    </div>
</div>
<img src="<%=request.getContextPath() %>/img/toTop.png" id="toTop" onclick="returnToTop()">
<script type="text/javascript">
$(function(){
	load();
	$(window).scroll(function(){
		if($(window).scrollTop()>100){
			$("#toTop").fadeIn(500);
		}else{
			$("#toTop").fadeOut(500);
		}
	});
});

function load(){
	$.ajax({
		url:"game",
		type:"post",
		data:"data",
		dataType:"json",
		success:function(game){
			var str="";
			for(var i=0;i<game.length;i++){
				str='<div class="game">'+
	                '<div class="img"><img src="'+game[i].img+'" alt=""></div>'+
	                '<div class="content">'+
	                    '<p class="name"><a class="title" href="'+game[i].introduceUrl+'">'+game[i].name+'</a></p>'+
	                    '<ul class="detail clear">'+
	                        '<li>发行：'+game[i].company+'</li>'+
	                        '<li>发售日期：'+game[i].date+'</li>'+
	                        '<li>类型：'+game[i].type+'</li>'+
	                        '<li>评分：'+game[i].score+'</li>'+
	                    '</ul>'+
	                '</div>'+
	            '</div>';
				$(".wrapper").append(str);
			}
			
		}
	});
};
function returnToTop(){
	if ($('html').scrollTop()) {
        $('html').animate({ scrollTop: 0 }, 1000);
        return false;
    }
    $('body').animate({ scrollTop: 0 }, 1000);
         return false;            
}
</script>
</body>
</html>