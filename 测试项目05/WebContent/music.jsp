<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>音乐排行榜</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<style type="text/css">
body, h1, h2, h3, h4, h5, h6, hr, p, blockquote, dl, dt, dd, ul, ol, li, pre, form, fieldset, legend, button, input, textarea, th, td { margin:0; padding:0; }
body, button, input, select, textarea { font:12px/1.5tahoma, arial, \5b8b\4f53; }
ul, ol { list-style:none; }
a { text-decoration:none; }
a:hover { text-decoration:none; }
button, input, select, textarea { font-size:100%; }
table { border-collapse:collapse; border-spacing:0; }
.clear:after{content:"";display:block;clear:both;}
.clear{zoom:1;}
.container{
	width:100%;
	
}.container .main-inner{
	width:1160px;
	margin:0px auto;
	overflow:hidden;
}
.container .main-inner .content-left{
	width:250px;
	padding:40px 0 10px 0;
	float:left;
	overflow:scroll;
	max-height:550px;
	border-left: 1px solid #aaa;
	border-right: 1px solid #aaa;
}.container .main-inner .content-right{
	width:850px;
	padding:40px;
}#wrapper-left{
	float:left;
	width:220px;
}#wrapper-right{
	float:right;
}
.content-left .list-item{
	width:200px;
	line-height: 40px;
	padding: 10px 0 10px 20px;
	border-bottom: 1px solid #eeeeee;
}.my-table th{
	height: 38px;
    background-color: #f7f7f7;
    background-position: 0 0;
    background-repeat: repeat-x;
    font-size: 20px;
}
.my-table .w1{
	width:90px;
	height: 18px;
    line-height: 18px;
    padding: 8px 10px;
    background-position: 0 -56px;
}
.my-table .w2{
	height: 18px;
	width:400px;
    line-height: 18px;
    padding: 8px 10px;
    background-position: 0 -56px;
}
.my-table .w3{
	text-align: left;
    font-weight: normal;
    color: #666;
        height: 18px;
    line-height: 18px;
    padding: 8px 10px;
    background-position: 0 -56px;
    width:90px;
}.my-table .w4{
	width: 150px;
	height: 18px;
    line-height: 18px;
    padding: 8px 10px;
    background-position: 0 -56px;
}.rank-list{
	    font-size: 15px;
	    
}
.rank-list tr:hover{
	background: #eee;
}
.rank-list .ranking{
	text-align: center;
	color:#CDC5BF;
}
.rank-list .title a{
	color:black;
	margin-left:10px;
	height:24px;
	padding:2px 0;
}
.rank-list .title a:hover{
	color:red;
}
.rank-list .title .play-icon{
	margin-top:4px;
}
.rank-list .time{
	padding:0 10px;
}
.odd{
	background-color: black;
}
.even{
	background-color: #EEE;
}li.list-item:hover {
	background: rgba(255,235,205,0.5);
}
#audio{
	height:50px;
	position:fixed;
	bottom:0px;
	left:80px;
	line-height: 50px;
	
}.collect-icon{
	position:absolute;
	top:75px;
	right:100px;
	cursor: pointer;
}#toTop{
	position: fixed;
	right:80px;
	bottom: 100px;
	cursor: pointer;
	display: none;
}#toTop:hover{
	content: url("<%=request.getContextPath()%>/img/toTop-hover.png");
}
</style>

<script type="text/javascript">
	$(function(){
		
		loadList();//加载榜单分类
		var listId=<%=request.getAttribute("listId")%>;
		loadContent(listId);//加载榜单内容
		$("body").delegate("img.play-icon","click",function(){//歌曲播放
			var player=document.getElementById("audio");//audio获取的是dom对象，不能获取jquery对象
			if($(this).hasClass("playing")){
				$(this).removeClass("playing").addClass("pausing").attr("src","img/pausing.png");
				player.pause();
			}else if($(this).hasClass("pausing")){
				$(this).addClass("playing").removeClass("pausing").attr("src","img/playing.png");
				player.play();
			}else{
				$(this).addClass("playing").attr("src","img/playing.png");
				$("img.play-icon").not(this).removeClass("playing").removeClass("pausing").attr("src","img/play.png");
				var url=$(this).next().attr("href");
				player.src=url;
				player.play();
			}
		});
		loadCollectionStatus();
		
		$(window).scroll(function(){
			if($(window).scrollTop()>100){
				$("#toTop").fadeIn(500);
			}else{
				$("#toTop").fadeOut(500);
			}
		});
	});

function loadList(){
	$.ajax({
		url:"music/musicTopList",
		type:"post",
		dataType:"json",
		data:"",
		success:function(data){
			var str="";
			for(var i=0;i<data.length;i++){
				str+='<li class="list-item"><a href="<%=request.getContextPath() %>/music?listId='+data[i].listId+'">'+data[i].name+'</a></li>';
			}
			$(".music-list").append(str);
		}
	});
}
function loadContent(listId){
	$.ajax({
		url:"music/musicListContent",
		type:"post",
		dataType:"json",
		data:{"listId":listId},
		success:function(songs){
			str="";
			for(var i=0;i<songs.length;i++){
				var singer="";
				if(songs[i].singer.length>15){
					singer=String(songs[i].singer).substring(0,15)+"...";
				}
				else{
					singer=songs[i].singer;
				}
				str+='<tr>'+
					'<td class="ranking">'+songs[i].rank+'</td>'+
					'<td class="title"><img src="img/play.png" class="play-icon"><a href="'+songs[i].singUrl+'">'+songs[i].singName+'</a></td>'+
					'<td class="time">'+songs[i].time+'</td>'+
					'<td class="singer">'+singer+'</td>'+
				'</tr>';
			}
			$(".rank-list").append(str);
		}
	});
}

function loadCollectionStatus(){
	var listId=<%=request.getAttribute("listId")%>
	$.ajax({
		url:"music/loadCollectionStatus",
		type:"post",
		dataType:"json",
		data:{"listId":listId},
		success:function(result){
			if(result==1){
				$(".collect-icon").attr("src","<%=request.getContextPath()%>/img/collected.png").addClass("collected");
			}
		}
	});
}
function updateCollectionStatus(img){
	var icon=$(img);
	if(<%=request.getSession().getAttribute("UID")%>==null){
		alert("该功能需要登录账号！")
	}else{
		if(icon.hasClass("collected")){
			var choice= confirm("你确定要取消收藏吗？");
			if(choice==true){
				deleteCollection();
			}else{
				
			}
		}else{
			var choice=confirm("你确定要收藏这个分类吗？");
			if(choice==true){
				addCollection();
			}
		}
	}
}
function deleteCollection(){
	var listId=<%=request.getAttribute("listId")%>
	$.ajax({
		url:"music/deleteCollection",
		type:"post",
		dataType:"json",
		data:{"listId":listId},
		success:function(result){
			if(result==1){
				$(".collect-icon").attr("src","<%=request.getContextPath()%>/img/uncollected.png").removeClass("collected");
			}
		}
	});
}
function addCollection(){
	var listId=<%=request.getAttribute("listId")%>
	$.ajax({
		url:"music/addCollection",
		type:"post",
		dataType:"json",
		data:{"listId":listId},
		success:function(result){
			if(result==1){
				$(".collect-icon").attr("src","<%=request.getContextPath()%>/img/collected.png").addClass("collected");
			}
		}
	});
}
function returnToTop(){
	if ($('html').scrollTop()) {
        $('html').animate({ scrollTop: 0 }, 1000);
        return false;
    }
    $('body').animate({ scrollTop: 0 }, 1000);
         return false;            
}
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<img class="collect-icon" alt="收藏" src="<%=request.getContextPath() %>/img/uncollected.png" onclick="updateCollectionStatus(this)">
<div class="container">
	<div class="main-inner">
		<div id="wrapper-left">
		<div class="content-left">
			<ul class="music-list">
<!-- 				<li class="list-item">网易云音乐</li> -->
			</ul>
		</div>
		</div>
		<div id="wrapper-right">
		<div class="content-right">
			<table class="my-table">
				<tr>
					<th class="w1">排名</th>
					<th class="w2">标题</th>
					<th class="w3">时长</th>
					<th class="w4">歌手</th>
				</tr>
				<tbody class="rank-list">
				</tbody>
			</table>
		</div>
		</div>	
	</div>
</div>
<audio controls class="audio" id="audio">	
  	<source src="https://music.163.com/song/media/outer/url?id=1359275278.mp3" type="audio/mpeg">
</audio>
<img src="<%=request.getContextPath() %>/img/toTop.png" id="toTop" onclick="returnToTop()">
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>