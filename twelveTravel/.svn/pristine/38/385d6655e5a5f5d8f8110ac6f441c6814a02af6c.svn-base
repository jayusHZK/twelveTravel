<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>
<link href="/twelveTravel/css/style.css" rel="stylesheet"
	type="text/css" />
<script type='text/javascript' src='/twelveTravel/js/jquery-1.10.2.js'></script>
<script type='text/javascript' src='/twelveTravel/js/ajaxfileupload.js'></script>
</head>

<body>

	<div class="formbody">
		<div class="formtitle">
			<span>基本信息</span>
		</div>
		<form action="/twelveTravel/changeuser/register" method="post">
			<ul class="forminfo">
				<li><label>用户名</label><input id="username" name="user_name"
					type="text" value="${userInfo.user_name }" class="dfinput" /></li>
				<li><label>密码</label><input id="password" name="password" type="password"
					value="${userInfo.password }" class="dfinput" /></li>
				<li><label>确认密码</label><input id="passwordAgain" name="passwordAgain"
					type="password" class="dfinput" /></li>
				<li><label>年龄</label><input name="age" type="text"
					value="${userInfo.age }" class="dfinput" /></li>
				<li><label>身份证</label><input id="code" name="code" type="text"
					value="${userInfo.code }" class="dfinput" /></li>
				<li><label>地址</label><input id="address" name="address" type="text"
					value="${userInfo.address }" class="dfinput" /></li>
				<li><label>头像</label><input name="fileList" id="fileList"
					type="file" class="" /> <input type="button" value="确认上传"
					class="btn" id="upload" /> <input type="hidden" name="headimg" />
				</li>
				<input type="hidden" name="user_id" value="${userInfo.user_id }" />
				<li id="bc" style="display: none"><label>&nbsp;</label><input type="submit" class="btn"
					id="save" value="确认保存" /></li>
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
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>
		</div>



	</div>


	<script type="text/javascript">
		function uploadimg() {
			$.ajaxFileUpload({
				url : "/twelveTravel/file/upload",
				type : "post",
				dataType : "text",
				fileElementId : "fileList",//表示上传文件input的id
				secureuri : false,//表示不已安全协议发送
				success : function(data) {
					console.log(data);
					var json = data.replace(/<.*?>/ig, "");
					var newdata = JSON.parse(json);
					if (newdata.code == 200) {
						$("[name='headimg']").val(newdata.msg);
					} else {
						alert("上传失败!");
					}
				}
			});
		}

		var role_id = "${userInfo.role.role_id}";
		$("#dp").val(role_id);

		$(function() {
			var fail=1;
			$("#username").blur(function(){
				var user_name=$("#username").val();
				$.ajax({
					type: "post",   
            		url: "/twelveTravel/changeuser/getUserLoginName",// 要请求的后台页面   
            		data:{"user_name":user_name} ,// 要传的参数  
	            	success: function(data){ 
	               		if(data.code!=0){
							alert("用户名已存在,请重新输入");
							fail=0;
							$("#username").val("");
							$("#username").focus();
							
						}else{
							fail=1;
							
						}
            		} 
				});
			});
			$("#passwordAgain").blur(function(){
				var passwordAgain=$("#passwordAgain").val();
				var password=$("#password").val();
				if(passwordAgain!=password){
					alert("两次密码不一致!");
					fail=0;
					
				}else{
					fail=1;
					
				}
			});
			$("#code").blur(function(){
				var code=$("#code").val();
				var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
				if(reg.test(code)==false){
					alert("身份证输入不合法！");
					fail=0;
					
				}else{
					fail=1;
					
				}
			});
			$("#upload").click(function() {
				uploadimg();
				if(fail==0){
					alert("上面输入信息有误请检查信息！");
				}else if(fail==1){
					$("#bc").show();
				}
			});
			$("#upload").click(function() {
				$(".tip").fadeIn(200);
			});

			$(".tiptop a").click(function() {
				$(".tip").fadeOut(200);
			});

			$(".sure").click(function() {
				$(".tip").fadeOut(100);
			});

			$(".cancel").click(function() {
				$(".tip").fadeOut(100);
			});
			//默认选择角色的下拉框值
			$("#dp").find("option:contains('请选择')").attr("selected", true);
		});
	</script>
</body>
</html>
