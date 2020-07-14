<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B站排行榜</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/basement.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bilirank.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/choosepage.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/bilirank.js"></script> --%>
<style type="text/css">
.collect-icon{
	position:absolute;
	top:75px;
	right:70px;
	cursor: pointer;
}
</style>
</head>
<body background="<%=request.getContextPath()%>/img/bilirank.jpg">
<jsp:include page="header.jsp"></jsp:include>
<div style="min-height:1000px">
<div id="navgator" class="n">
    <div class="wrapper">
        <div id="rank-table">
            <ul id="category">     
            </ul>
        </div>
    </div>
</div>
<img class="collect-icon" alt="收藏" src="<%=request.getContextPath() %>/img/uncollected.png" onclick="updateCollectionStatus(this)">
<div class="search">
        <form action="<%=request.getContextPath() %>/keysearch" class="search-form" method="GET">
                <input name="keyword" type="text" autocomplete="off" accesskey="s" x-webkit-speech="" x-webkit-grammar="builtin:translate" class="search-keyword">
                <button class="search-submit" type="submit" value=""></button>
        </form>
    </div>
<div id="content" class="n">
    <div class="wrapper clear">
        <ul class="rank-list">
        </ul>
    </div>
</div>
</div>
<div class="page-wrapper">
        <p class="content">
            <a id="first" href="bilirank?categoryId=<%=request.getAttribute("categoryId") %>">首页</a>
            <a id="last" href="bilirank?categoryId=<%=request.getAttribute("categoryId") %>&pageNum=<%=request.getAttribute("totalPages")%>">尾页</a>
            跳转到<input type="number"  min="1" max="${totalPage}" id="setpage">页
            <span id="totalnum">共<%=request.getAttribute("totalPages") %>页</span>
        </p>
    </div>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">

$(function(){
	load();	
	loadCollectionStatus();
});

//使用输入框跳转页面
$("#setpage").keyup(function (e) { 
	
	if(event.keyCode ==13){
		var totalPages=${totalPages};
		var categoryId=<%=request.getAttribute("categoryId")%>;
		var page=$("#setpage").val();
		if(page>0&&page<=totalPages){
			window.location.href='<%=request.getContextPath()%>/bilirank?categoryId='+categoryId+"&pageNum="+page;
		}else{
			alert("页数超出范围，无法跳转！");
		}
	}
	
});

function load(){
	
	var categoryId=<%=request.getAttribute("categoryId")%>;
	var currentPage=<%=request.getAttribute("currentPage")%>;
$.ajax({
    type: "post",
    url: "bilirank_content",
    data: {"categoryId":categoryId,"currentPage":currentPage},
    dataType: "json",
    success: function (result) {
    	 var category=result["category"];
    	 var rank=result["rank"];
    	 var totalPages=<%=request.getAttribute("totalPages")%>;
        for(var i=0;i<category.length;i++){
        	str='<li class="content"><a href="<%=request.getContextPath() %>/bilirank?categoryId='+category[i].categoryId+'">'+category[i].categoryName+'</a></li>';
            $("#category").append(str);
        }
        for(var i=0;i<rank.length;i++){
        	str='<li class="rank-item">'+
        			'<div class="clear">'+
                		'<div class="num">'+rank[i].ranking+'</div>'+
                			'<div class="container">'+
                				'<div class="content">'+
                   					'<a href="'+rank[i].videoUrl+'" class="title" target="_blank">'+rank[i].videoName+'</a>'+
                    				'<p class="detail">'+
                        			'播放量：<span class="times">'+rank[i].cnTimes+'</span>'+
                        			'弹幕数：<span class="danmu">'+rank[i].danmuNum+'</span>'+
                        			'UP主 ：<a href="'+rank[i].upLoaderUrl+'" class="uploader" target="_blank">'+rank[i].upLoader+'</a>'+
                    				'</p>'+
                    			'</div>'+
                				'<div class="score">'+
                   					'综合得分：<span class="pts">'+rank[i].score+'</span>'+
                				'</div>'+
                			'</div>'+
                		'</div>'+
                    '</li>';
            $(".rank-list").append(str);
   		}
        str='';
        while(true){
        	var pre=currentPage-1;
        	var next=currentPage+1;
        	//page在前
        	if(currentPage<=5){
        		if(currentPage==1){
            		str+='<a id="pre" href="javascript:void(0)">上一页</a>';
            	}else{
            		var pre=currentPage-1;
            		str+='<a id="next" href="bilirank?CategoryId='+categoryId+'&pageNum='+pre+'">上一页</a>';
            	}
        		for(var i=1;i<=5;i++){
        			if(i==currentPage){
        				str+='<a id="current" class="selected" href="bilirank?CategoryId='+categoryId+'&pageNum='+i+'">'+i+'</a>';
        			}else{
        				str+='<a href="bilirank?CategoryId='+categoryId+'&pageNum='+i+'">'+i+'</a>';
        			}
        		}str+='<a id="next" href="bilirank?CategoryId='+categoryId+'&pageNum='+next+'">下一页</a>';
        		break;
        	}//page在中
        	else if (currentPage>=totalPages-5) {
        		str+='<a id="current" href="bilirank?CategoryId='+categoryId+'&pageNum='+pre+'">上一页</a>';
				for(var i=totalPages-4;i<=totalPages;i++){
					if(i==currentPage){
        				str+='<a id="current" class="selected" href="bilirank?CategoryId='+categoryId+'&pageNum='+i+'">'+i+'</a>';
        			}else{
        				str+='<a href="bilirank?CategoryId='+categoryId+'&pageNum='+i+'">'+i+'</a>';
        			}
				}
				if(currentPage==totalPages){
					str+='<a id="next" href="javascript:void(0)">下一页</a>'
				}else{
					str+='<a id="next" href="bilirank?CategoryId='+categoryId+'&pageNum='+next+'">下一页</a>';
				}
				
				break;
			}//page在后
        	else{
				str+='<a id="pre" href="bilirank?CategoryId='+categoryId+'&pageNum='+pre+'">上一页</a>';
				for(var i=currentPage-2;i<currentPage+2;i++){
					if(i==currentPage){
        				str+='<a id="current" class="selected" href="bilirank?CategoryId='+categoryId+'&pageNum='+i+'">'+i+'</a>';
        			}else{
        				str+='<a href="bilirank?CategoryId='+categoryId+'&pageNum='+i+'">'+i+'</a>';
        			}
				}
				str+='<a id="next" href="bilirank?CategoryId='+categoryId+'&pageNum='+next+'">下一页</a>';
				break;
			}
        }
        $("#first").after(str);
        
    }
});
};
function loadCollectionStatus(){
	var categoryId=<%=request.getAttribute("categoryId")%>;
	$.ajax({
		url:"bili/loadCollectionStatus",
		type:"post",
		data:{"categoryId":categoryId},
		dataType:"json",
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
		alert("该功能需要登录账号！");
	}else{
		if(icon.hasClass("collected")){
			var choice= confirm("你确定要取消收藏吗？");
			if(choice==true){
				deleteCollection();
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
	var categoryId=<%=request.getAttribute("categoryId")%>;
	$.ajax({
		url:"bili/deleteCollection",
		type:"post",
		dataType:"json",
		data:{"categoryId":categoryId},
		success:function(result){
			if(result==1){
				$(".collect-icon").attr("src","<%=request.getContextPath()%>/img/uncollected.png").removeClass("collected");
			}
		}
	});
}
function addCollection(){
	var categoryId=<%=request.getAttribute("categoryId")%>;
	$.ajax({
		url:"bili/addCollection",
		type:"post",
		dataType:"json",
		data:{"categoryId":categoryId},
		success:function(result){
			if(result==1){
				$(".collect-icon").attr("src","<%=request.getContextPath()%>/img/collected.png").addClass("collected");
			}
		}
	});
}
</script>
</body>
</html>