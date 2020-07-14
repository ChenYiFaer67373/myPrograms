<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		load();
	});
function load(){
    $.ajax({
        type: "post",
        url: "bili",
        data: "data",
        dataType: "json",
        success: function (result) {
        	 var category=result["category"];
        	 var rank=result["rank"];
            for(var i=0;i<category.length;i++){
            	
                str='<td>'+category[i].categoryName+'</td>';
                $("#t1 th").append(str);
            }
            for(var i=0;i<rank.length;i++){
            	str='<tr><td>'+rank[i].ranking+'</td><td><a href="'+rank[i].videoUrl+'">'+rank[i].videoName+'</a></td><td>'+rank[i].playTimes+'</td><td>'+rank[i].danmuNum+'</td><td><a href="'+rank[i].upLoaderUrl+'">'+rank[i].upLoader+'</a></td><td>'+rank[i].score+'</td></tr>';
            	$(".rank").append(str);
            }
//             for(var c in result["rank"]){
//                 str='<tr><td>'+c["ranking"]+'</td><td><a href="'+c["videoUrl"]+'">'+c.videoName+'</a></td><td>'+c.playTimes+'</td><td>'+c.danmuNum+'</td><td><a href="'+c.upLoaderUrl+'">'+c.upLoader+'</a></td><td>'+c.score+'</td></tr>';
//                 $(".rank").append(str);
//             }

        }
    });
};
</script>
</head>
<body>
	<table id="t1">
        <th>
            <td>分类</td>
        </th>
    </table>

    <table id="t2">
        <tbody>
        	<tr>
            <td>排名</td>
            <td>标题</td>
            <td>播放量</td>
            <td>弹幕数</td>
            <td>up主</td>
            <td>综合评分</td>
        	</tr>
        </tbody>
        <tbody class="rank">
            <tr>
            <td></td> <td></td> <td></td> <td></td> <td> </td> <td></td>
            </tr>
        </tbody>
    </table>
</body>
</html>