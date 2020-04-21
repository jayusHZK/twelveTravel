<%@ page language='java' import='java.util.*' pageEncoding='utf-8'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>
<html>
<head>

<title>My JSP 'userlist.jsp' starting page</title>
<link href='/twelveTravel/css/style.css' rel='stylesheet'
	type='text/css' />
<script type='text/javascript' src='/twelveTravel/js/jquery-1.10.2.js'></script>
<style type="text/css">
.myul {
	height: 35px;
	margin-left: 30px;  
	width: 898px;
	float: left
}

.myul li {
	float: left;
	height: 35px;
	line-height: 35px;
	font-size: 13px;
}

.myul li input,select {
	height: 35px;
	line-height: 35px;
	border: 1px solid #ccc;
}

#attractions_name {
	border-radius: 3px;
	margin-left: 5px;
}

#beat_id {
	border-radius: 3px;
	margin-left: 5px;
}
#country_id {
	border-radius: 3px;
	margin-left: 5px;
}
#province_id {
	border-radius: 3px;
	margin-left: 5px;
}

#boxcontent {
	width: 1100px;
	height: 70px;
	line-height: 70px;
}
</style>

</head>

<body>
	<div class='place'>
		<span>位置：</span>
		<ul class='placeul'>
			<li><a href='#'>景点模块</a></li>
			<li><a href='#'>攻略分页</a></li>
		</ul>
	</div>
	<div class='rightinfo'>

		<div class='tools'>
			<ul class="myul">
				<li><input id="txt" type="text" placeholder="搜点什么？"></li>
			</ul>

			<ul class='toolbar1'>
				<li id="find"><span><img
						src='/twelveTravel/images/ico06.png' /></span>查询</li>
			</ul>

		</div>


		<table class='tablelist'>
			<thead>
				<tr>
					<th>评论人</th>
					<th>头像</th>
					<th>评论时间</th>
					<th>内容</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="boxcontent">
			</tbody>
		</table>


		<div class='pagin'>
			<div class='message'>
				共<i class='blue' id="count">1256</i>条记录，当前显示第&nbsp;<i class='blue'
					id="index">2</i>页
			</div>
			<ul class='paginList'>

				<li class='paginItem'><a href='javascript:;' id="first">首</a></li>
				<li class='paginItem'><a href='javascript:;' id="before">上</a></li>
				<li class='paginItem'><a href='javascript:;' id="next">下</a></li>
				<li class='paginItem'><a href='javascript:;' id="last">末</a></li>

			</ul>
		</div>


		<div class='tip'>
			<div class='tiptop'>
				<span>提示信息</span><a></a>
			</div>

			<div class='tipinfo'>
				<span><img src='/twelveTravel/images/ticon.png' /></span>
				<div class='tipright'>
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class='tipbtn'>
				<input name='' type='button' class='sure' value='确定' />&nbsp; <input
					name='' type='button' class='cancel' value='取消' />
			</div>

		</div>




	</div>

	<script type='text/javascript'>
		$('.tablelist tbody tr:odd').addClass('odd');
		//将时间戳转换为时间
			function timeConverter(time){
				return new Date(parseInt(time)*1000).toLocaleString().replace(/:\d{1,2}$/,' ');
			}
		//查询用户分页的方法   index表示页码
		function getdata(index) {
			var content = {
				index : index
			};
			//获取景点名
			content.content = $("#txt").val();
			$.ajax({
						url : "/twelveTravel/strate/getbclist",
						data : content,
						type : "post",
						dataType : "json",
						success : function(data) {
							console.log(data);
							var html = "";
							//循环服务器返回的数据    拼接html
							$(data.obj).each(
											function() {
												html += "<tr style='width:100%;height:60px'> ";
												html += "<td>" + this.user.user_name+ "</td>";
												html += "<td ><img width='50px' height='50px' style='border-radius: 50%;overflow:hidden'   src='/twelveTravel/upload/"+ this.user.headimg+ "' /></td>";
												html += "<td>"+ timeConverter(this.comment_time)+ "</td>";
												html += "<td title='"+this.comment+"'>"+(this.comment.length >8?this.comment.substring(0,8)+"...":this.comment)+"</td>";
												html += "<td style='width:191px'><a id='del' href='/twelveTravel/strate/detelebcomment?comment_id="+ this.comment_id
														+ "'  class='tablelink'><li style='line-height:33px;margin-right:1px;margin-left:16px;background:url(../images/toolbg.gif) repeat-x; border:solid 1px #d3dbde; float:left;;border-radius: 3px; behavior:url(js/pie.htc);'><span style='float:left;; margin-top:5px;'><img src='/twelveTravel/images/t03.png' /></span>删除</li></a></td>";
												html += "</tr> "; 
											});
							//设置总条数
							$("#count").text(data.count);
							//设置当前页
							$("#index").text(data.index);
							//将拼接的html添加到对应的容器中去
							$("#boxcontent").empty().append(html);
							//设置首页的页码
							$("#first").data("index", 1);
							//设置最后一页的页码
							$("#last").data("index", data.pageCount);
							//设置上一页的页码
							$("#before").data("index",
									(data.index == 1 ? 1 : (data.index - 1)));
							//设置下一页的页码
							$("#next")
									.data(
											"index",
											(data.index == data.pageCount ? data.pageCount
													: (data.index + 1)));
						}
					});
		}

		$(function() {
			getdata(1);
			//分页按钮的点击事件
			$("#first,#before,#last,#next").click(function() {
				var index = $(this).data("index");//获取分页方法中设置的页码值
				getdata(index);//将对应的页码值传入分页的方法进行分页
			});

			$("#find").click(function() {
				getdata(1);
			});
			$(".tab").click(function() {
				alert(1);
			});
			
		});
	</script>
</body>
</html>
