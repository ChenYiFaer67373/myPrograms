<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css">
<style type="text/css">
body, h1, h2, h3, h4, h5, h6, hr, p, blockquote, dl, dt, dd, ul, ol, li, pre, form, fieldset, legend, button, input, textarea, th, td { margin:0; padding:0; }
    body, button, input, select, textarea { font:12px/1.5tahoma, arial, \5b8b\4f53; }
    h1, h2, h3, h4, h5, h6{text-align: center}
    address, cite, dfn, em, var { font-style:normal; }
    code, kbd, pre, samp { font-family:couriernew, courier, monospace; }
    small{ font-size:12px; }
    ul, ol { list-style:none; }
    a { text-decoration:none; }
    a:hover { text-decoration:none; }
    sup { vertical-align:text-top; }
    sub{ vertical-align:text-bottom; }
    legend { color:#000; }
    fieldset, img { border:0; }
    button, input, select, textarea { font-size:100%; }
    table { border-collapse:collapse; border-spacing:0; }
    .clear:after{content:"";display:block;clear:both;}
    .clear{zoom:1;}
    .body-wrapper{
        width: 1160px;
        min-height:220px;
        margin: 30px auto;
        border-radius: 15px;
        background: rgba(255, 255, 255, 0.7);

    }.moudle{

    }.body-wrapper h3{
        height: 50px;
    }
    .moudle .content-left{
        width: 150px;
        float: left;
        text-align: center;
    }
    .moudle .content-right{
        width: 950px;
        float: right;
        max-height: 500px;
        overflow: auto;
    }
    .moudle .content-left ul{
    	width:100%;
        font-size: 20px;
        height:40px;
        line-height: 40px;
    }.moudle .content-left li:hover{
        background: #50b3f5;
    }
    #tab-tr1,#tab-tr2{
        border-bottom: 1px solid gray;
        height: 50px;
    }
    #tab-tr1 .th1{
        width: 100px;
    }#tab-tr1 .th2{
        width:550px;
    }#tab-tr1 .th3{
        width: 200px;
    }#tab-tr1 .th4{
        width: 100px;
    }
    
    #tab-tr2 .th1{
        width: 50px;
    }#tab-tr2 .th2{
        width:400px;
        
    }#tab-tr2 .th3{
        width: 100px;
    }#tab-tr2 .th4{
        width: 400px;
    }
    .bili-content tr:hover,.music-content tr:hover {
	background:#66FFFF
}.td-videoName,.td-singName{
	text-align: left;
}
</style>

<script type="text/javascript">
$(function(){
	loadMyBiliCollections();
	loadMyMusicListCollections();
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
});
function loadMyBiliCollections(){
	$.ajax({
		url:"loadMyBiliCollections",
		type:"post",
		dataType:"json",
		data:"",
		success:function(data){
			str="";
			for(var i=0;i<data.length;i++){
				
				var userbilicategory=data[i];
				var categoryId=userbilicategory["biliCategory"].categoryId;
				var categoryName=userbilicategory["biliCategory"].categoryName;
				str+='<li class="myCollectedbiliName"><a onclick="changeMyBiliCategory(\''+categoryId+'\')">'+categoryName+'</a></li>';
				if(i==0){
					changeMyBiliCategory(categoryId);
				}
			}
			$(".myBiliList").append(str);
		}
	});
};
function loadMyMusicListCollections(){
	$.ajax({
		url:"loadMyMusicListCollections",
		type:"post",
		dataType:"json",
		data:"",
		success:function(data){
			str="";
			
			for(var i=0;i<data.length;i++){
				var userMusicList=data[i];
				var listId=userMusicList["musicTopList"].listId;
				var name=userMusicList["musicTopList"].name;
				str+='<li class="myCollectedMusicListName"><a onclick="changeMyMusicList(\''+listId+'\')">'+name+'</a></li>';
				if(i==0){
					changeMyMusicList(listId);
				}
			}
			$(".myMusicList").append(str);
			
		}
	});
};
function changeMyBiliCategory(biliCategoryId){
	$.ajax({
		url:"changeMyBiliCategory",
		type:"post",
		dataType:"json",
		data:{"biliCategoryId":biliCategoryId},
		success:function(data){
			str="";
			$(".myBiliCategoryContent").html("");
			for(var i=0;i<data.length;i++){
				str+='<tr class="myBiliCategoryContent">'+
                    '<td><span class="ranking">'+data[i].ranking+'</span></td>'+
                    '<td class="td-videoName"><a href="'+data[i].videoUrl+'" class="title">'+data[i].videoName+'</a></td>'+
                    '<td><a href="'+data[i].upLoaderUrl+'" class="upLoader">'+data[i].upLoader+'</a></td>'+
                    '<td><span class="score">'+data[i].score+'</span></td>'+
                '</tr>';
			}
			$(".bili-content").append(str);
		}
	});
}
function changeMyMusicList(musicListId){
	$.ajax({
		url:"changeMyMusicList",
		type:"post",
		dataType:"json",
		data:{"musicListId":musicListId},
		success:function(data){
			str="";
			$(".myMusicListContent").html("");
			for(var i=0;i<data.length;i++){
				str+='<tr class="myMusicListContent">'+
                    '<td><span class="ranking">'+data[i].rank+'</span></td>'+
                    '<td class="td-singName"><img src="img/play.png" class="play-icon">&nbsp;&nbsp;<a href="'+data[i].singUrl+'" class="title">'+data[i].singName+'</a></td>'+
                    '<td><span class="time">'+data[i].time+'</span></td>'+
                    '<td><span class="score">'+data[i].singer+'</span></td>'+
                '</tr>';
			}
			$(".music-content").append(str);
		}
	});
}
</script>
</head>
<html>
<body background="<%=request.getContextPath()%>/img/background.jpg">

<jsp:include page="header.jsp"></jsp:include>
<div class="body-wrapper">
        <h3 class="categoryTitle">我的收藏————bilibili排行榜</h3>
        <div class="moudle clear">
            <div class="content-left clear">
                <ul class="myBiliList clear">
                </ul>
            </div>
            <div class="content-right">
                <table class="bili-content">
                    <tr id="tab-tr1">
                        <th class="th1">排名</th>
                        <th class="th2">标题</th>
                        <th class="th3">UP主</th>
                        <th class="th4">综合评分</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
<div class="body-wrapper">
        <h3 class="categoryTitle">我的收藏————网易云歌单</h3>
        <div class="moudle clear">
            <div class="content-left clear">
                <ul class="myMusicList clear">
                </ul>
            </div>
            <div class="content-right">
                <table class="music-content">
                    <tr id="tab-tr2">
                        <th class="th1">排名</th>
                        <th class="th2">歌名</th>
                        <th class="th3">时长</th>
                        <th class="th4">演唱者</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
<audio controls class="audio" id="audio">	
  	<source src="" type="audio/mpeg">
</audio>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>