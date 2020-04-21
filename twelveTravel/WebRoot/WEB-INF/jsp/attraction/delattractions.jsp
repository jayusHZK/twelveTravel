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
		<div class="tip9">
		<div class="tiptop9">
			<span>提示信息</span><a></a>
		</div>
		<div class="tipinfo9">
			<span><img src="/twelveTravel/images/ticon.png" /></span>
			<div class="tipright9">
				<p>你已删除了该景点</p>
			</div>
		</div>
		<div class="tipbtn9">
			<input name="" type="button" class="sure9" value="确定" />
		</div>
	</div>
	<div class='place'>
		<span>位置：</span>
		<ul class='placeul'>
			<li><a href='#'>景点模块</a></li>
			<li><a href='#'>景点分页</a></li>
			<li><a href='#'>显示景点</a></li>
		</ul>
	</div>

	<div class='rightinfo1'>

		<div class='tools'>

			<ul class='toolbar'>
				<li class='click'><a
					href="/twelveTravel/attractions/toaddattractions"><span><img
							src='/twelveTravel/images/t01.png' /></span>添加</a></li>
			</ul>
			<ul class="myul">
				<li>景点</li>
				<li><input id="attractions_name" type="text"></li>
				<li id="border-radius" style="margin-left: 30px">国家</li>
				<li><select id="country_id">
						<option value="0">全部</option>
						<c:forEach items="${conlist}" var="country">
							<option value="${country.country_id}">${country.country_name}</option>
						</c:forEach>
				</select></li>
				<li id="border-radius" style="margin-left: 30px">省份</li>
				<li><select id="province_id" name="" class="dfinput"
					style="width: 100px">
						<option value="0">全部</option>
						<c:forEach items="${prolist}" var="item">
							<option value="${item.province_id}">${item.province_name}</option>
						</c:forEach>
				</select></li>
				<li id="border-radius" style="margin-left: 30px">城市</li>
				<li><select id="beat_id">
						<option value="0">全部</option>
						<c:forEach items="${beatlist}" var="beat">
							<option value="${beat.beat_id}">${beat.beat_name}</option>
						</c:forEach>
				</select></li>

			</ul>


			<ul class='toolbar1'>
				<li id="find"><span><img
						src='/twelveTravel/images/ico06.png' /></span>查询</li>
			</ul>

		</div>


		<table class='tablelist'>
			<thead>
				<tr>
					<th><input name='' type='checkbox' value='' checked='checked' /></th>
					<th>编号<i class='sort'><img
							src='/twelveTravel/images/px.gif' /></i></th>
					<th>景点名称</th>
					<th>国家</th>
					<th>省份</th>
					<th>城市</th>
					<th>景点简介</th>
					<th>景点图片</th>
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
	</div>

	<script type='text/javascript'>
		$(function() {
			//点击删除按钮显示一个提示框
			$(document).ready(function() {
				$("#save").click(function() {
					$(".tip9").fadeIn(200);
				});
				$(".tiptop9 a").click(function() {
					$(".tip9").fadeOut(200);
				});
				$(".sure9").click(function() {
					$(".tip9").fadeOut(100);
				});
				$(".cancel9").click(function() {
					$(".tip9").fadeOut(100);
				});
			});
			
			//添加一个样式
			$('.tablelist tbody tr:odd').addClass('odd');

			//查询用户分页的方法   index表示页码
			function getdata(index) {
			
				var content = {index : index};  //页码
				//获取景点名
				content.attractions_name = $("#attractions_name").val();
				//获取省份
				content.beat_id = $("#beat_id").val();
				//获取省份
				content.country_id = $("#country_id").val();
				//获取省份
				content.province_id = $("#province_id").val();
				
				$.ajax({
					url : "/twelveTravel/attractions/getattractionslist",  //执行景点分页的路径
					data : content,  //提交的参数
					type : "get",  //提交的类型
					dataType : "json",  //参数的类型
					success : function(data) {
						console.log(data);
						var html = "";
						//循环服务器返回的数据    拼接html
						$(data.obj).each(function() {
							console.log(this);
							html += "<tr style='width:100%;height:60px'> ";
							html += "<td><input name='' type='checkbox' value='' /></td>";
							html += "<td>"	+ this.attractions_id+ "</td>";
							html += "<td>"+ this.attractions_name+ "</td>";
							html += "<td>"	+ this.country.country_name+ "</td>";
							html += "<td>"+ this.province.province_name+ "</td>";
							html += "<td>"+ this.beat.beat_name+ "</td>";
							html += "<td title='"+this.attractions_introduce+"'>"+ (this.attractions_introduce.length > 6 ? (this.attractions_introduce.substring(0,6) + "...")	: this.attractions_introduce)+ "</td>";
							html += "<td ><img width='50px' height='50px' style='border-radius: 50%;overflow:hidden'   src='/twelveTravel/upload/"+ this.attractions_img+ "' /></td>";
							html += "<td style='width:191px'><a href='/twelveTravel/attractions/toeditattractions?attractions_id="
									+ this.attractions_id
									+ "' class='tablelink'><li style='line-height:33px;margin-right:6px;margin-left:7px;background:url(../images/toolbg.gif) repeat-x; border:solid 1px #d3dbde; float:left;;border-radius: 3px; behavior:url(js/pie.htc);'><span style='float:left; margin-top:4px;'><img src='/twelveTravel/images/t02.png' /></span>修改</li></a><a href='/twelveTravel/attractions/todelattractions?attractions_id="
									+ this.attractions_id
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
								$("#before").data(	"index",(data.index == 1 ? 1: (data.index - 1)));
								//设置下一页的页码
								$("#next").data("index",(data.index == data.pageCount ? data.pageCount: (data.index + 1)));
							}
						});
			}

			$(function() {
				getdata(1);  //景点分页的方法

				//分页按钮的点击事件
				$("#first,#before,#last,#next").click(function() {
					var index = $(this).data("index");//获取分页方法中设置的页码值
					getdata(index);//将对应的页码值传入分页的方法进行分页
				});
				
				//点击查询按钮 执行景点分页的方法
				$("#find").click(function() {
					getdata(1);
				});

				//点击确认按钮  将用户列表页显示出来
				$(".sure9").click(function() {
					$(".rightinfo1").show();
				});
			});
		});
	</script>
</body>
</html>