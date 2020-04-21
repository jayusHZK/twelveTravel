<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Home</title>
<link href="/twelveTravel/css/cssh/bootstrap.css" rel='stylesheet'
	type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="/twelveTravel/css/style1.css" rel='stylesheet'
	type='text/css' />
<link href="/twelveTravel/css/style.css" rel='stylesheet'
	type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!--webfont-->
<script type="text/javascript"
	src="/twelveTravel/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/twelveTravel/js/login.js"></script>
<script src="/twelveTravel/js/jquery.easydropdown.js"></script>
<!--Animation-->
<script src="/twelveTravel/js/wow.min.js"></script>
<link href="/twelveTravel/css/animate.css" rel='stylesheet'
	type='text/css' />
<script>
	new WOW().init();
</script>

</head>

<body>
	<div class="header">
		<div class="header-left">
			<div class="logo">
				<a href="frist"><img src="/twelveTravel/images/logo1.png" alt="" /></a>
			</div>
			<div class="menu">
				<a class="toggleMenu" href="#"><img
					src="/twelveTravel/images/nav.png" alt="" /></a>
				<ul class="nav" id="nav">


				</ul>
				<script type="text/javascript"
					src="/twelveTravel/js/responsive-nav.js"></script>
			</div>
			<div class="clearfix"></div>
		</div>

		<div class="header_right" style="display:${user.user_id!=null?"none":''}">
			<!-- start search-->
			<!----//search-scripts---->
			<div id="loginContainer">
				<a href="#" id="loginButton"><img
					src="/twelveTravel/images/login.png"><span>Login</span></a>

				<div id="loginBox">
					<form id="loginForm">
						<fieldset id="body">
							<fieldset>
								<input type="hidden" name="action" value="/main/tologin"/>
							</fieldset>
							<fieldset>
								<label for="user_name">姓名</label> <input type="text"
									name="user_name" id="user_name">
							</fieldset>
							<fieldset>
								<label for="password">密码</label> <input type="password"
									name="password" id="password">
							</fieldset>
							
							<input type="button" id="login" value="登录"> <a
								href="/twelveTravel/changeuser/toregister"><input
								type="button" id="register" value="注册"> </a>
							</fieldset>
						
					</form>
				</div>

			</div>
			<div class="clearfix"></div>
		</div>
		<div style="height: 10px;width: 100%"></div>
		<div float="right" style="display:${user.user_id!=null?'':"none"}">
		<img style="border-radius:50%;float:left" width="50" height="50" line-height="90" src="/twelveTravel/upload/${user.headimg }"> 
				<span style="float:left;line-height: 50px;margin-left: 20px">${user.user_name }</span>				
				<c:if test="${sessionScope.user.role.role_id==1}">
					<a style="line-height: 50px;margin-left: 20px" href="/twelveTravel/main/tomain">进入后台</a>
				</c:if>
		<a style="line-height: 50px;margin-left: 20px" href="#" class="loginout" target="_parent">退出登录</a>
		</div>

		<div class="clearfix"></div>
	</div>

	<script type="text/javascript"></script>
	<div class="banner wow fadeInUp" data-wow-delay="0.4s">
		<div class="container_wrap">
			<h1>What are you looking for?</h1>
			<ul class="myul">
				<li><input id="find" type="text"></li>
			</ul>
			<div class="contact_btn">
				<label id="serach" class="btn1 btn-2 btn-2g">serach</label>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="content_top wow bounceInRight" data-wow-delay="0.4s">
		<div class="container">
			<div style="height:20px;width: 100%"></div>

		</div>
	</div>
	<div class="content_middle wow bounceInLeft" data-wow-delay="0.4s">
		<div class="container">
			<div class="content_middle_box">

				<div class="tlinks">
					Collect from <a href="http://www.cssmoban.com/">网页模板</a>
				</div>
				<div class="middle_grid wow fadeInUp" data-wow-delay="0.4s">
					<div id="box" style="width: 100%;height:100%">
						
							
							
						
					</div>
				</div>
				<div class="pagin">
    				<div class="message">共<i class="blue" id="count"></i>条记录，当前显示第&nbsp;<i class="blue" id="index">&nbsp;</i>页</div>
       				 <ul class="paginList">
        
       					 <li class="paginItem current"><a href="javascript:;" id="first">首</a></li>
        				 <li class="paginItem"><a href="javascript:;" id="before">上</a></li>
       					 <li class="paginItem"><a href="javascript:;" id="next">下</a></li>
        				<li class="paginItem"><a href="javascript:;" id="last">尾</a></li>
       
       				 </ul>
    			</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<div class="footer_top">
				<h3>Subscribe to our newsletter</h3>
				<form>
					<span> <i><img src="/twelveTravel/images/mail.png"
							alt=""></i> <input type="text" value="Enter your email"
						onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Enter your email';}">
						<label class="btn1 btn2 btn-2 btn-2g"> <input
							name="submit" type="submit" id="submit" value="Subscribe">
					</label>
						<div class="clearfix"></div>
					</span>
				</form>
			</div>
			<div class="footer_grids">
				<div class="footer-grid">
					<h4>Ipsum Quis</h4>
					<ul class="list1">
						<li><a href="contact.html">Contact</a></li>
						<li><a href="#">Mirum est</a></li>
						<li><a href="#">placerat facer</a></li>
						<li><a href="#">claritatem</a></li>
						<li><a href="#">sollemnes </a></li>
					</ul>
				</div>
				<div class="footer-grid">
					<h4>Quis Ipsum</h4>
					<ul class="list1">
						<li><a href="#">placerat facer</a></li>
						<li><a href="#">claritatem</a></li>
						<li><a href="#">sollemnes </a></li>
						<li><a href="#">Claritas</a></li>
						<li><a href="#">Mirum est</a></li>
					</ul>
				</div>
				<div class="footer-grid last_grid">
					<h4>Follow Us</h4>
					<ul class="footer_social wow fadeInLeft" data-wow-delay="0.4s">
						<li><a href=""> <i class="fb"> </i>
						</a></li>
						<li><a href=""><i class="tw"> </i> </a></li>
						<li><a href=""><i class="google"> </i> </a></li>
						<li><a href=""><i class="u_tube"> </i> </a></li>
					</ul>
					<div class="copy wow fadeInRight" data-wow-delay="0.4s">
						<p>
							Copyright &copy; 2014.Company name All rights reserved.More
							Templates <a href="http://www.cssmoban.com/" target="_blank"
								title="模板之家">模板之家</a> - Collect from <a
								href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
						</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		`
	</div>
	<script type="text/javascript">
		
		function getdata(index){
			var content={index:index};
			//获取查询输入的数据
			content.find=$("#find").val();
			$.ajax({
				url:"/twelveTravel/selectDetail/getselectDetail",
				data:content,
				type:"post",
				dataType:"json",
				success:function(data){
				console.log(111)
				console.log(data);
					var html="";
					$(data.obj).each(function(){
						html+="<div class='col-md-6' style='margin-top: 20px'>";
						html+="<div class='grid1'>";
						html+="<div class='index_img'>";
						html+="<img src='/twelveTravel/upload/"+this.attractions_img+"' class='img-responsive' style='width:540px;height:150px' alt='' />";
						html+="</div>";
						html+="<i class='m_home'> </i>";						
						html+="<div class='inner_wrap1'>";
						html+="<ul class='item_module'>";
						html+="<li class='module_left'></li>";
						html+="<li class='module_right'><img alt='' />";
						html+="<h5>"+this.attractions_name+"</h5>";
						html+="<a href='/twelveTravel/detail/tobeat?beat_id="+this.beat.beat_id+"'>"+this.beat.beat_name+"</a>";
						html+="<p attractions_introduce='"+this.attractions_introduce+"'>"+(this.attractions_introduce.length>20?(this.attractions_introduce.substring(0,50)+"..."):this.attractions_introduce)+"</p>";
						html+="<a href='/twelveTravel/detail/toattD?attr_id="+this.attractions_id+"' class='content_btn'>....read more</a></li>";
						html+="<div class='clearfix'></div>";
						html+="</ul></div>";
						html+="</div></div>";
					});
						$("#box").empty().append(html);
						$("#count").text(data.count);
						$("#index").text(data.index);
						$("#first").data("index",1);
    					$("#before").data("index",(data.index==1?1:(data.index-1)));
    					$("#next").data("index",(data.index==data.pageCount?data.pageCount:(data.index+1)));
    					$("#last").data("index",data.pageCount);
				}
			
			});
			
			
		};
		function load(){
				$.ajax({
				url:"/twelveTravel/selectDetail/getAttractionsByhot",
				data:"",
				type:"get",
				dataType:"json",
				success:function(data){
					console.log(data);
					var html="";
					$(data.msg).each(function(){
						html+="<div class='col-md-6' style='margin-top: 20px'>";
						html+="<div class='grid1'>";
						html+="<div class='index_img'>";
						html+="<img src='/twelveTravel/upload/"+this.attractions_img+"' class='img-responsive' style='width:540px;height:150px' alt='' />";
						html+="</div>";
						html+="<i class='m_home'> </i>";						
						html+="<div class='inner_wrap1'>";
						html+="<ul class='item_module'>";
						html+="<li class='module_left'></li>";
						html+="<li class='module_right'><img alt='' />";
						html+="<h5>"+this.attractions_name+"</h5>";
						html+="<a href='/twelveTravel/detail/tobeat?beat_id="+this.beat.beat_id+"'>"+this.beat.beat_name+"</a>";
						html+="<p attractions_introduce='"+this.attractions_introduce+"'>"+(this.attractions_introduce.length>20?(this.attractions_introduce.substring(0,50)+"..."):this.attractions_introduce)+"</p>";
						html+="<a href='/twelveTravel/detail/toattD?attr_id="+this.attractions_id+"' class='content_btn'>....read more</a></li>";
						html+="<div class='clearfix'></div>";
						html+="</ul></div>";
						html+="</div></div>";
						
						$("#box").empty().append(html);
					});
				}
			
			});
			
		}
		$(function(){
			load();
			$(".loginout").click(function() {
			if (confirm('系统提示，您确定要退出本次登录吗?')) {
				location.href ="/twelveTravel/changeuser/loginout";
			}
			});
			$("#first,#before,#next,#last").click(function(){
				var index=$(this).data("index");
				getdata(index);
			});
			$("#serach").click(function(){
				getdata(1);
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
		});	
	</script>

</body>
</html>
