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
	getComment(1);
	function getComment(index) {
		var attr_id=$("#attr_id").val();
		var data={};
		data.attr_id=attr_id;
		data.index=index;
		$.post("/twelveTravel/detail/getattrc",data,function(date){
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
				html+="<img style='width:100%;height:100%;border-radius:50%;' src='/twelveTravel/upload/"+this.user.headimg+"' alt=''></div>";
				html+="<div class='ps-review__content'>";
				html+=" <header>";
				html+="	<p>By<a href='javascript:void(0)'> "+this.user.user_name+"</a> - "+timeConverter(this.comment_time)+"</p>";
				html+=" </header>";
				html+=" <p>"+this.comment+"</p>";
				html+="</div>";
				html+="<div style='width:1200px;height:10px '></div>";
				html+="</div>";
			});
			$("#attrcommentdiv").append(html);
			$("#lookMore").data("index",date.msg.index);
			$("#commentcount").text(date.msg.count);
		},"json");
	}
	$("#lookMore").click(function() {
		var index=$(this).data("index");
		var index1=parseInt(index)+1;
		getComment(index1);
	});
	//将时间戳转换为时间
	function timeConverter(time){
		return new Date(parseInt(time)*1000).toLocaleString().replace(/:\d{1,2}$/,' ');
	}
	
	$("#comment").click(function() {
		
		var regu = "^[ ]+$";
		var re = new RegExp(regu);
		var comment=$("#txt").val();
		//是否有用户已登录
		if($("#user_id").val()==null||$("#user_id").val()==""||re.test($("#user_id").val())){
			alert("请先登录");
		}else if(comment==null ||comment=="" ||re.test(comment)){//对评论内容进行判断
			alert("请输入评论");
		}else {
			var data={};
			data.user_id=$("#user_id").val();
			data.attr_id=$("#attr_id").val();
			data.comment=comment;
			$.post("/twelveTravel/detail/addattrcomment",data,function(date){
				console.log(date);
				if(date.code==200){
					alert("评论成功");
					$("#txt").val("");
					//var commentid=$("#beatcommentdiv").children().eq(0).data("id");
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
						
						//获取评论框的第一个子集
						//var commentid=$("#beatcommentdiv").children().eq(0).data("id");
						//将拼出的数据显示在评论框第一条
						//$("[data-id='"+commentid+"']").html(html1);
						$("#attrcommentdiv").prepend(html1);
						$("#commentcount").text(parseInt($("#commentcount").text())+1);
					//}
				}
			},"json");
		}
	});
});