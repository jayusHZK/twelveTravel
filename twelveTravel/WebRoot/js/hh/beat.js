$(function() {
	$(".loginout").click(function() {
		if (confirm('系统提示，您确定要退出本次登录吗?')) {
			location.href ="/twelveTravel/changeuser/loginout";
		}
	});
	$("#login").click(function(){
		
		//取数据,这里用到了用户名和密码
			var user_name=$("#user_name").val();
			var password=$("#password").val();
		$.ajax({
		url:"/twelveTravel/changeuser/login",
		data:{user_name:user_name,password:password},
		type:"post",
		dataType:"json",
		success:function(data){			
			if(data.code==200){
				location.reload();
			}else if(data.code==400){
				alert("用户名或密码错误");
			}
		}
	
		});
	});
	var beat_id=$("#beat_id").val();
	//获取区域内景点
	$.post("/twelveTravel/detail/getattrlist",{beat_id:beat_id},function(date){
		console.log(date);
		var html="";
		$(date.msg).each(function(item) {
			html+="<a href='/twelveTravel/detail/toattD?attr_id="+this.attractions_id+"'>";
			html+="<div class='col-md-3 grid_box'>";
			html+="<img style='width: 255px;height: 180px' src='/twelveTravel/upload/"+this.attractions_img+"' class='img-responsive' alt=''>";
			html+="<span class='zoom-icon'></span></a>";
			html+="<div class='grid_box2'>";
			html+="<h4><a href='#'>"+this.attractions_name+"</a></h4>";
			html+="<p>"+this.attractions_hot+"人查看过</p></div>";
			html+="</div></a>";
		});
		$("#attrDiv").empty().append(html);
	},"json");
	
	getComment(1);
	//获取区域评论
	function getComment(index) {
		var beat_id=$("#beat_id").val();
		var data={};
		data.beat_id=beat_id;
		data.index=index;
		$.post("/twelveTravel/detail/getbeatcomment",data,function(date){
			console.log(date);
			if(index==1&&date.msg.count==0){
				$("#lookMore").text("暂无评论");
			}else if(date.msg.obj.length<10){
				$("#lookMore").text("到底了..");
			}
			html="";
			$(date.msg.obj).each(function() {
				html+="<div data-id=hh"+this.comment_id+"  style='width:1200px;border: 1px #ccc solid;'>";
				html+="<div class='' style='float: left;width: 50px;height:50px;margin: 10px'>";
				html+="<img style='width:100%;height:100%' src='/twelveTravel/upload/"+this.user.headimg+"' alt=''></div>";
				html+="<div class='ps-review__content'>";
				html+=" <header>";
				html+="	<p>By<a href='javascript:void(0)'> "+this.user.user_name+"</a> - "+timeConverter(this.comment_time)+"</p>";
				html+=" </header>";
				html+=" <p>"+this.comment+"</p>";
				html+="</div>";
				html+="<div style='width:1200px;height:10px '></div>";
				html+="</div>";
			});
			$("#beatcommentdiv").append(html);
			$("#lookMore").data("index",date.msg.index);
			$("#commentcount").text(date.msg.count);
			
			
		},"json");
	}
	
	//将时间戳转换为时间
	function timeConverter(time){
		return new Date(parseInt(time)*1000).toLocaleString().replace(/:\d{1,2}$/,' ');
	}
	//查看更多点击事件
	$("#lookMore").click(function() {
		var index=$(this).data("index");
		var index1=parseInt(index)+1;
		getComment(index1);
	});
	
	//发表评论
	$("#comment").click(function() {
		var regu = "^[ ]+$";
		var re = new RegExp(regu);
		var comment=$("#txt").val();
		//对评论内容进行判断
		console.log($("#user_id").val())
		if($("#user_id").val()==null||$("#user_id").val()==""||re.test($("#user_id").val())){
			alert("请先登录");
		}else if(comment==null ||comment=="" ||re.test(comment)){
			alert("请输入评论");
		}else {
			var data={};
			data.user_id=$("#user_id").val();
			data.beat_id=$("#beat_id").val();
			data.comment=comment;
			$.post("/twelveTravel/detail/addbeatcomment",data,function(date){
				console.log(date);
				if(date.code==200){
					alert("评论成功");
					$("#txt").val("");
					//拼出一条评论数据
					html1="";
					html1+="<div  style='width:1200px;border: 1px #ccc solid;'>";
					html1+="<div class='' style='float: left;width: 50px;height:50px;margin: 10px'>";
					html1+="<img style='width:100%;height:100%' src='/twelveTravel/upload/"+$("#user_headimg").val()+"' alt=''></div>";
					html1+="<div class='ps-review__content'>";
					html1+=" <header>";
					html1+="	<p>By<a href='javascript:void(0)'> "+$("#user_name1").val()+"</a> - "+timeConverter(Date.parse(new Date())/1000)+"</p>";
					html1+=" </header>";
					html1+=" <p>"+comment+"</p>";
					html1+="</div>";
					html1+="<div style='width:1200px;height:10px '></div>";
					html1+="</div>";
					//获取评论框的第一个子集
					//var commentid=$("#beatcommentdiv").children().eq(0).data("id");
					//将拼出的数据显示在评论框第一条
					//$("[data-id='"+commentid+"']").html(html1);
					$("#beatcommentdiv").prepend(html1);
					$("#lookMore").text("到底了..");
					$("#commentcount").text(parseInt($("#commentcount").text())+1);
				}
			},"json");
		}
	});
});
	