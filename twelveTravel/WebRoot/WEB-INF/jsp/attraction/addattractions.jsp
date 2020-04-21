<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加用户</title>
<link href="/twelveTravel/css/style.css" rel="stylesheet"
	type="text/css" />
<script type='text/javascript' src='/twelveTravel/js/jquery-1.10.2.js'></script>
<script type='text/javascript' src='/twelveTravel/js/ajaxfileupload.js'></script>
<script type='text/javascript' src='/twelveTravel/js/tan.js'></script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">景点模块</a></li>
			<li><a href="#">添加景点</a></li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>基本信息</span>
		</div>
		<form>
			<ul class="forminfo">
				<li><label>景点名称</label><input name="attractions_name"
					id="attractions_name" type="text"
					value="${attractionsInfo.attractions_name }" class="dfinput" /><i></i></li>
				<li><label>国家</label><select id="cou" class="dfinput"
					style="width: 150px" name="" onchange="conuntryChange()">
						<option>请选择</option>
						<c:forEach items="${conlist}" var="item">
							<option value="${item.country_id}">${item.country_name}</option>
						</c:forEach>
				</select></li>

				<li><label>省</label><select id="pro" class="dfinput"
					style="width: 150px" name="province_id">

				</select></li>
				<li><label>城市</label><select id="beat" class="dfinput"
					style="width: 150px" name="beat_name">

				</select>
				<li><label>简介</label> <textarea onblur="" onfocus=""
						id="clicktitle" rows="10" cols="47" name="attractions_introduce"
						placeholder="简介至少五十个字"></textarea> <i id="showtitle"
					style="display: none;margin-left: 79px">简介不合格</i> <i
					id="showtitle1" style="display: none;margin-left: 79px">简介字数少于50字</i>
				</li>
				<li><label>景点图片</label><input name="fileList" id="fileList"
					type="file" class="" /><i></i> <input type="button" value="确认上传"
					class="btn" id="upload" /> <input type="hidden"
					name="attractions_img" id="attractions_img" /></li>
				<input type="hidden" name="attractions_id"
					value="${attractionsInfo.attractions_id }" />
				<li><label>&nbsp;</label><input type="button" class="btn"
					id="submit" value="确认保存" /></li>
			</ul>
		</form>

		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo">
				<span><img src="/twelveTravel/images/ticon.png" /></span>
				<div class="tipright">
					<p>上传成功</p>
					<cite></cite>
				</div>
			</div>
			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />
			</div>
		</div>
		
		<div class="tip1">
			<div class="tiptop1">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo1">
				<span><img src="/twelveTravel/images/ticon.png" /></span>
				<div class="tipright1">
					<p style="margin-left: 30px">请填写景点名</p>
					<cite></cite>
				</div>
			</div>
			<div class="tipbtn1">
				<input name="" type="button" class="sure1" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="button" class="cancel1" value="取消" />
			</div>
		</div>
		<div class="tip2">
			<div class="tiptop2">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo2">
				<span><img src="/twelveTravel/images/ticon.png" /></span>
				<div class="tipright2">
					<p style="margin-left: 30px">请填写国家</p>
					<cite></cite>
				</div>
			</div>
			<div class="tipbtn2">
				<input name="" type="button" class="sure2" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="button" class="cancel2" value="取消" />
			</div>
		</div>
				<div class="tip3">
			<div class="tiptop3">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo3">
				<span><img src="/twelveTravel/images/ticon.png" /></span>
				<div class="tipright3">
					<p style="margin-left: 30px">请填写省份</p>
					<cite></cite>
				</div>
			</div>
			<div class="tipbtn3">
				<input name="" type="button" class="sure3" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="button" class="cancel3" value="取消" />
			</div>
		</div>
				<div class="tip4">
			<div class="tiptop4">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo4">
				<span><img src="/twelveTravel/images/ticon.png" /></span>
				<div class="tipright4">
					<p style="margin-left: 30px">请填写城市</p>
					<cite></cite>
				</div>
			</div>
			<div class="tipbtn4">
				<input name="" type="button" class="sure4" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="button" class="cancel4" value="取消" />
			</div>
		</div>
				<div class="tip5">
			<div class="tiptop5">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo5">
				<span><img src="/twelveTravel/images/ticon.png" /></span>
				<div class="tipright5">
					<p style="margin-left: 30px">请填写简介</p>
					<cite></cite>
				</div>
			</div>
			<div class="tipbtn5">
				<input name="" type="button" class="sure5" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="button" class="cancel5" value="取消" />
			</div>
		</div>
		<div class="tip7">
			<div class="tiptop7">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo7">
				<span><img src="/twelveTravel/images/ticon.png" /></span>
				<div class="tipright7">
					<p style="margin-left: 30px">简介字数少于50字</p>
					<cite></cite>
				</div>
			</div>
			<div class="tipbtn7">
				<input name="" type="button" class="sure7" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="button" class="cancel7" value="取消" />
			</div>
		</div>
				<div class="tip6">
			<div class="tiptop6">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo6">
				<span><img src="/twelveTravel/images/ticon.png" /></span>
				<div class="tipright6">
					<p style="margin-left: 30px">请上传图片</p>
					<cite></cite>
				</div>
			</div>
			<div class="tipbtn6">
				<input name="" type="button" class="sure6" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="button" class="cancel6" value="取消" />
			</div>
		</div>

	</div>


	<script type="text/javascript">
		//上传图片的uploadimg方法
		function uploadimg() {
			$.ajaxFileUpload({
				url : "/twelveTravel/file/upload",  //上传图片文件的路径
				type : "post",   //提交的方式
				dataType : "text",   //参数的类型
				fileElementId : "fileList",  //表示上传文件input的id
				secureuri : false,  //表示不已安全协议发送
				success : function(data) {
					console.log(data);
					var json = data.replace(/<.*?>/ig, "");// 将data的文件替换
					var newdata = JSON.parse(json);
					if (newdata.code == 200) {
						$("[name='attractions_img']").val(newdata.msg);
					} else {
						alert("失败");
					}
				}
			});
		}

		$(function() {
			//点击提交按钮 执行添加景点
			$("#submit").click(function() {
				//获取参数
				var data = {};
				data.attractions_name = $("#attractions_name").val(); //景点名称
				data.attractions_img = $("#attractions_img").val(); //景点图片
				data.attractions_introduce = $("#clicktitle").val(); //景点简介
				data.beat_id = $("#beat").val(); //景点所属城市
				data.province_id = $("#pro").val(); //景点所属省份
				data.country_id = $("#cou").val(); //景点所属国家
				
				//验证添加景点的合格性
				if( $("#attractions_name").val()==""){
					$(".tip1").show();
					return;
				}else{
					$(".tip1").hide();
				}
				 if( $("#cou").val()==""){
					$(".tip2").show();
					return;
				}else{
					$(".tip2").hide();
				}
				 if( $("#pro").val()==""){
					$(".tip3").show();
					return;
				}else{
					$(".tip3").hide();
				}
				 if( $("#beat").val()==""){
					$(".tip4").show();
					return;
				}else{
					$(".tip4").hide();
				}
				 if( $("#clicktitle").val()==""){
					$(".tip5").show();
					return;
				}else{
					$(".tip5").hide();
				}
				 if( $("#clicktitle").val().length<50 && $("#clicktitle").val() != ""){
					$(".tip7").show();
					return;
				}else{
					$(".tip7").hide();
				}
				 if( $("#attractions_img").val()==""){
					$(".tip6").show();
					return;
				}else{
					$(".tip6").hide();
				}
					$.ajax({
						url : "/twelveTravel/attractions/addattractions", //执行添加景点的路径
						data : data, //需要传递的参数
						type : "post", //提交的方式
						dataType : "json", //参数的类型
						success : function(data) {
							console.log(data); //打印数据
								if (data.code != 0) { //如果有数据的话 就跳转到景点分页列表
									location.href = "/twelveTravel/attractions/toattractionslist";
								} else { //如果没有数据的话 就返回到添加景点页面
									location.href = "/twelveTravel/attractions/toaddattractions";
								}
						}
					});
									
			});

			//上传图片的点击事件
			$("#upload").click(function() {
				//执行上传图片的方法
				uploadimg();
			});			
			
			//实现onchange方法
			$("#cou").change(function() {
				var country_id = $(this).val();//将值赋给country_id
				conuntryChange(country_id);
			});

			//实现onchange方法
			$("#pro").change(function() {
				var beat_id = $(this).val();//将值赋给beat_id
				beatChange(beat_id);
			});

			function conuntryChange(id) {
				$.ajax({
							url : "/twelveTravel/attractions/toaddprov", //添加省份的路径
							data : {country_id : id}, //将conuntryChange已经获取到的国家id赋给country_id
							type : "get", //提交的方式
							dataType : "json", //参数的类型
							success : function(data) {
								console.log(data);
								var html = "";
								html += "<option>请选择</option>";
								$(data.msg).each(function() {
									html += "<option value="+this.province_id+">"+ this.province_name+ "</option>"; //将省份id,省份名加载到省份下拉框里面去
								});
								$("#pro").empty().append(html); //将原有的数据清空 然后再加载上去							
							}
						});
			}

			function beatChange(id) {
				$.ajax({
					url : "/twelveTravel/attractions/toaddbeatv", //添加城市的路径
					data : {province_id : id},//将beatChange已经获取到的城市id赋给province_id
					type : "get", //提交的方式
					dataType : "json", //参数的类型
					success : function(data) {
						console.log(data);
						var html = "";
						html += "<option>请选择</option>";
						$(data.msg).each(
								function() {
									html += "<option value="+this.beat_id+">"+ this.beat_name + "</option>"; //将城市id,城市名加载到城市下拉框里面去
								});
						$("#beat").empty().append(html); //将原有的数据清空 然后再加载上去				 						
					}
				});
			}

			//判断简介的合法性
			//失去焦点时
			$("#clicktitle").blur(function() {
				//如果简介大于等于50字则合格	
				if ($("#clicktitle").val().length >= 50) {
					$("#showtitle").toggle(function() {
						$("#showtitle").css("display", "none");
						$("#showtitle1").css("display", "none");
					});
				}
			});
			
			$("#clicktitle").blur(
					function() {
						//如果简介小于50字并且不为空时
						//则提示  简介字数小于50字
						if ($("#clicktitle").val().length < 50
								&& $("#clicktitle").val().length != "") {
							$("#showtitle1").toggle(function() {
								$("#showtitle1").css("display", "block");
							});
						}
					});
					
			//失去焦点时 如果文本框的val值为空
			//则提示   简介填写不合格
			$("#clicktitle").blur(function() {
				if ($("#clicktitle").val().length == "") {
					$("#showtitle").toggle(function() {
						$("#showtitle").css("display", "block");
					});
				}
			});

			//默认下拉框的值为  请选择
			$("#dp").find("option:contains('请选择')").attr("selected", true);

		});
	</script>
</body>
</html>
