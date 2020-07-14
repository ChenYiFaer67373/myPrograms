<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜你所想</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/basement.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bilirank_search.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/bilirank.js"></script> --%>
<style type="text/css">

</style>
</head>
<body>
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
<div class="search">
        <form action="<%=request.getContextPath() %>/keysearch" class="search-form" method="GET">
                <input id="keyword" name="keyword" type="text" autocomplete="off" accesskey="s" x-webkit-speech="" x-webkit-grammar="builtin:translate" class="search-keyword" value="<%=request.getAttribute("keyword")%>">
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
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">

$(function(){
	load();
});

function load(){
	var keyword=$("#keyword").val();
$.ajax({
    type: "post",
    url: "show_keysearch",
    data: {"keyword":keyword},
    dataType: "json",
    success: function (result) {
    	 var rank=result["rank"];
        for(var i=0;i<rank.length;i++){
        	str='<li class="rank-item">'+
        			'<div class="clear">'+
                		'<div class="num">'+rank[i].biliCategory.categoryName+'</div>'+
                			'<div class="container">'+
                				'<div class="content">'+
                   					'<a href="'+rank[i].videoUrl+'" class="title">'+rank[i].videoName+'</a>'+
                    				'<p class="detail">'+
                        			'播放量：<span class="times">'+rank[i].cnTimes+'</span>'+
                        			'弹幕数：<span class="danmu">'+rank[i].danmuNum+'</span>'+
                        			'UP主 ：<a href="'+rank[i].upLoaderUrl+'" class="uploader">'+rank[i].upLoader+'</a>'+
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
    }
});
};

</script>
</body>
</html>