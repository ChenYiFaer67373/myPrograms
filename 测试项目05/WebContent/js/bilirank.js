$(function(){
	load();
	titleLengthLimit();
	
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
        	
            str='<li class="content"><a href="javascript:void(0)" onclick="changeCategoryId('+category[i].categoryId+')" >'+category[i].categoryName+'</a></li>';
            $("#category").append(str);
        }
        for(var i=0;i<rank.length;i++){
        	str='<li class="rank-item">'+
        			'<div class="clear">'+
                		'<div class="num">'+rank[i].ranking+'</div>'+
                			'<div class="container">'+
                				'<div class="content">'+
                   					'<a href="'+rank[i].videoUrl+'" class="title">'+rank[i].videoName+'</a>'+
                    				'<p class="detail">'+
                        			'播放量：<span class="times">'+rank[i].playTimes+'</span>'+
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
        var totalPage=request.getSession().getAttribute("totalPage");
        str='<a href="" class="pagenum">1</a>'+
        	'<a href="" class="pagenum">2</a>'+
        	'<a href="" class="pagenum">3</a>'+
        	'<a href="" class="pagenum">4</a>'+
        	'<a href="" class="pagenum">5</a>';
        $("#next").after(str);
        $("#totalnum").html(totalPage);
    }
});
};

function changeCategoryId(categoryId) {
	$(".rank-list").html("");
	$.ajax({
		type: "post",
	    url: "bili/changeCategoryId",
	    data: {"categoryId":categoryId},
	    dataType: "json",
	    success:function(rank){
	    	for(var i=0;i<rank.length;i++){
	    		str='<li class="rank-item">'+
    			'<div class="clear">'+
            		'<div class="num">'+rank[i].ranking+'</div>'+
            			'<div class="container">'+
            				'<div class="content">'+
               					'<a href="'+rank[i].videoUrl+'" class="title">'+rank[i].videoName+'</a>'+
                				'<p class="detail">'+
                    			'播放量：<span class="times">'+rank[i].playTimes+'</span>'+
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