<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改用户</title>
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
			<li><a href="#">用户模块 </a></li>
			<li><a href="#">用户分页</a></li>
			<li><a href="#">修改用户信息</a></li>
		</ul>
	</div>

	<div class="formbody">
		<div class="formtitle">
			<span>原始个人信息</span>
		</div>
		<form >
	<ul class="forminfo">
				<li><label>用户名</label><input onblur="" onfocus=""  id="pname"  name="user_name"  type="text"
					value="${userInfo.user_name }" class="dfinput"  placeholder="*用户名长度为3~6并且由中文组成" />
					<input type="hidden" id="user_id" name="user_id" value="${userInfo.user_id }">
					<i class="red" id="showtitle" style="display: none;margin-left: 79px">*用户名长度不合格</i>
					<i class="red" id="showtitle1" style="display: none;margin-left: 79px">*用户名长度小于三位</i>
					<i class="red" id="showtitle2" style="display: none;margin-left: 79px">*用户名长度大于六位</i>
					</li>
				<li><label>密码</label><input  onblur="" onfocus=""  id="ppassword" name="password"  type="password"
					value="${userInfo.password }" class="dfinput"  placeholder="*密码长度为6为"  />
					<i class="red" id="showpassword" style="display: none;margin-left: 79px">*密码长度不合格</i>
					<i class="red" id="showpassword1" style="display: none;margin-left: 79px">*密码长度小于六位</i>
					<i class="red" id="showpassword2" style="display: none;margin-left: 79px">*密码长度大于六位</i>
				</li>
				<li id="showpassword"  style="display:none"><label>确认密码</label><input onblur="" onfocus=""  id="againpassword"  type="password" class="dfinput"  />
				</li>
				<li><label>角色</label><select id="dp" name="role.role_id"class="dfinput">
							<option >请选择</option>
							<c:forEach items="${rolelist }" var="role">
							<option value="${role.role_id }">${role.role_name }</option>
						</c:forEach>
				</select></li>
				<li><label>年龄</label><input id="age" name="age" type="text"
					value="${userInfo.age }" class="dfinput" /></li>
				<li><label>身份证</label><input onblur="" onfocus=""  id="pcode"  name="code" type="text"
					value="${userInfo.code }" class="dfinput"  placeholder="*身份证长度为12~18位"  />
						<i class="red" id="showcode" style="display: none;margin-left: 79px">*身份证长度不合格</i>
					<i class="red" id="showcode1" style="display: none;margin-left: 79px">*身份证长度小于12位</i>
					<i class="red" id="showcode2" style="display: none;margin-left: 79px">*身份证长度大于18位</i>
					</li>
				<li><label>地址</label><input id="address" name="address" type="text"
					value="${userInfo.address }" class="dfinput" /></li>
				<li><label>头像</label><input name="fileList" id="fileList"
					type="file" class="" /> <input type="button" value="确认上传"
					class="btn" id="upload" /> <input id="img" type="hidden" name="headimg" />
				</li>
				<input type="hidden" name="user_id" value="${userInfo.user_id }" />
				<li><label>&nbsp;</label><input type="button" class="btn" id="save"
					value="确认修改" /></li>
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
					<p style="margin-left: 30px">请填写用户名</p>
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
					<p style="margin-left: 30px">请填写密码</p>
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
					<p style="margin-left: 30px">请填写角色</p>
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
					<p style="margin-left: 30px">请填写年龄</p>
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
					<p style="margin-left: 30px">请填写身份证</p>
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
					<p style="margin-left: 30px">请填写地址</p>
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
				<div class="tip8">
			<div class="tiptop8">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo8">
				<span><img src="/twelveTravel/images/ticon.png" /></span>
				<div class="tipright8">
					<p>是否确认修改该用户</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>
			<div class="tipbtn8">
				<input name="" type="button" class="sure8" value="确定" />&nbsp; <input
					name="" type="button" class="cancel8" value="取消" />
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
						$("[name='headimg']").val(newdata.msg);
					} else {
						alert("失败");
					}
				}
			});
		}
		
		//获取角色的id
		var role_id = "${userInfo.role.role_id}";
		//将获取的角色id赋给角色下拉框设置的id
		$("#dp").val(role_id);

		$(function() {
			//上传图片的点击事件
			$("#upload").click(function() {
				//执行上传图片的方法
				uploadimg();
			});
			//修改用户的点击事件
			$("#save").click(function(){
				//验证添加用户的合格性
				if( $("#pname").val()==""){
					$(".tip1").show();
					return;
				}else{
					$(".tip1").hide();
				}
				 if( $("#ppassword").val()==""){
					$(".tip2").show();
					return;
				}else{
					$(".tip2").hide();
				}
				 if( $("#address").val()==""){
					$(".tip7").show();
					return;
				}else{
					$(".tip7").hide();
				}
				 if( $("#pcode").val()==""){
					$(".tip5").show();
					return;
				}else{
					$(".tip5").hide();
				}
				 if( $("#age").val()==""){
					$(".tip4").show();
					return;
				}else{
					$(".tip4").hide();
				}
				 if( $("#img").val()== ""){
					$(".tip6").show();
					return;
				}else{
					$(".tip6").hide();
				}
				 if( $("#dp").val()==""){
					$(".tip3").show();
					return;
				}else{
					$(".tip3").hide();
				}
				//如果用户的所有信息都不为空的时候   弹出框提示  是否确认修改该用户的信息
				if($("#pname").val()!=""&&$("#ppassword").val()!=""&&$("#address").val()!=""&&$("#pcode").val()!=""&&$("#age").val()!=""&&$("#img").val()!=""){
						$(".tip8").fadeIn(200);
					}
				//弹出框右上角关闭的点击事件	
				$(".tiptop8 a").click(function() {
					$(".tip8").fadeOut(200);
				});
				//修改用户
				//点击确认的话就修改用户的数据
				$(".sure8").click(function(){
					$(".tip8").fadeOut(100);	
					
					//获取参数
					var data = {};
					data.user_id = $("#user_id").val(); //用户id
					data.user_name = $("#pname").val(); //用户名
					data.password = $("#ppassword").val(); //用户密码
					data.againpassword = $("#againpassword").val(); //确认密码
					data.address = $("#address").val(); //用户地址
					data.code = $("#pcode").val(); //用户身份证
					data.age = $("#age").val(); //用户年龄
					data.headimg= $("#img").val(); //用户头像
					data.role_id= $("#dp").val(); //用户角色
	
						$.ajax({
							url : "/twelveTravel/user/edituser", //执行添加用户的路径
							data : data, //需要传递的参数
							type : "post", //提交的方式
							dataType : "json", //参数的类型
							success : function(data) {
								console.log(data); //打印数据
									if (data.code != 0) { //如果有数据的话 就跳转到用户分页列表
										location.href = "/twelveTravel/user/touserlist";
									} else { //如果没有数据的话 就返回到修改用户页面
										location.href = "/twelveTravel/user/toupdateuser";
									}
							}
						});
					});													
				});
				//修改用户
				//点击取消 就取消修改景用户的数据并返回
				$(".cancel8").click(function() {
					$(".tip8").fadeOut(100);
					//验证修改用户的合格性
					if( $("#pname").val()==""){
						$(".tip1").show();
						return;
					}else{
						$(".tip1").hide();
					}
					 if( $("#ppassword").val()==""){
						$(".tip2").show();
						return;
					}else{
						$(".tip2").hide();
					}
					 if( $("#address").val()==""){
						$(".tip7").show();
						return;
					}else{
						$(".tip7").hide();
					}
					 if( $("#pcode").val()==""){
						$(".tip5").show();
						return;
					}else{
						$(".tip5").hide();
					}
					 if( $("#age").val()==""){
						$(".tip4").show();
						return;
					}else{
						$(".tip4").hide();
					}
					 if( $("#img").val()== ""){
						$(".tip6").show();
						return;
					}else{
						$(".tip6").hide();
					}
					 if( $("#dp").val()==""){
						$(".tip3").show();
						return;
					}else{
						$(".tip3").hide();
					}
					return;
				});			
			
			//点击上传图片按钮显示提示框
			$(document).ready(function() {
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
			});
			
				//判断用户的合法性
				//失去焦点时
				$("#pname").blur(function(){		
					//如果用户名为3~6位则合格	
					if ($("#pname").val().length >= 3 && $("#pname").val().length <= 6) {
						$("#showtitle").toggle(function() {
							$("#showtitle").css("display", "none");
							$("#showtitle1").css("display", "none");
							$("#showtitle2").css("display", "none");
						});
					}
				});
				
				$("#pname").blur(function(){			
					//如果用户名小于三位并且不为空时
					//则提示  用户名小于三位
					if ($("#pname").val().length < 3 && $("#pname").val().length != "") {
						$("#showtitle1").toggle(function() {
							$("#showtitle1").css("display", "block");
						});
					}
				});
				
				$("#pname").blur(function(){		
					//如果用户名大于六位并且不为空时
					//则提示  用户名大于六位	
					if ($("#pname").val().length > 6 && $("#pname").val().length != "") {
						$("#showtitle2").toggle(function() {
							$("#showtitle2").css("display", "block");
						});
					}
				});
				//失去焦点时 如果文本框的val值为空
				//则提示   用户名填写不合格
				$("#pname").blur(function(){			
					if ($("#pname").val().length == "") {
						$("#showtitle").toggle(function() {
							$("#showtitle").css("display", "block");
						});
					}
				});
	
				//判断密码的合法性
				//失去焦点时
				$("#ppassword").blur(function(){		
					//如果密码为6~12位则合格	
					if ($("#ppassword").val().length >= 6 && $("#ppassword").val().length <= 12) {
						$("#showpassword").toggle(function() {
							$("#showpassword").css("display", "none");
							$("#showpassword1").css("display", "none");
							$("#showpassword2").css("display", "none");
						});
					}
				});
				
				$("#ppassword").blur(function(){			
					//如果密码小于六位并且不为空时
					//则提示  密码小于六位
					if ($("#ppassword").val().length < 6  && $("#ppassword").val().length != "") {
						$("#showpassword1").toggle(function() {
							$("#showpassword1").css("display", "block");
						});
					}
				});
				
					$("#ppassword").blur(function(){			
					//如果密码大于六位并且不为空时
					//则提示  密码大于六位
					if ($("#ppassword").val().length > 6  && $("#ppassword").val().length != "") {
						$("#showpassword2").toggle(function() {
							$("#showpassword2").css("display", "block");
						});
					}
				});
				
				//失去焦点时 如果文本框的val值为空
				//则提示   密码填写不合格
				$("#ppassword").blur(function(){			
					if ($("#ppassword").val().length == "") {
						$("#showpassword").toggle(function() {
							$("#showpassword").css("display", "block");
						});
					}
				});
				
				//判断身份证的合法性
				//失去焦点时
				$("#pcode").blur(function(){		
					//如果身份证为12~18位则合格	
					if ($("#pcode").val().length >= 12 && $("#ppassword").val().length <= 18) {
						$("#showcode").toggle(function() {
							$("#showcode").css("display", "none");
							$("#showcode1").css("display", "none");
							$("#showcode2").css("display", "none");
						});
					}
				});
				
				$("#pcode").blur(function(){			
					//如果身份证小于12位并且不为空时
					//则提示  身份证小于12位
					if ($("#pcode").val().length < 12  && $("#pcode").val().length != "") {
						$("#showcode1").toggle(function() {
							$("#showcode1").css("display", "block");
						});
					}
				});
				
					$("#pcode").blur(function(){			
					//如果身份证大于18位并且不为空时
					//则提示  身份证大于18位
					if ($("#pcode").val().length > 18  && $("#pcode").val().length != "") {
						$("#showcode2").toggle(function() {
							$("#showcode2").css("display", "block");
						});
					}
				});
				
				//失去焦点时 如果文本框的val值为空
				//则提示   身份证填写不合格
				$("#pcode").blur(function(){			
					if ($("#pcode").val().length == "") {
						$("#showcode").toggle(function() {
							$("#showcode").css("display", "block");
						});
					}
				});
			
		});
	</script>
</body>
</html>
