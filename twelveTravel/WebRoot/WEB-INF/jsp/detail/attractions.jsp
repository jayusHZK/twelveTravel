<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'attractions.jsp' starting page</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<link href="${pageContext.request.contextPath }/css/style1.css"
	rel='stylesheet' type='text/css' />
	<link href="${pageContext.request.contextPath }/css/cssh/beat.css"
	rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/login.js"></script>
<script
	src="${pageContext.request.contextPath }/js/jquery.easydropdown.js"></script>
<script src="${pageContext.request.contextPath }/js/wow.min.js"></script>
<link href="${pageContext.request.contextPath }/css/animate.css"
	rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/hh/beat.js"></script>
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- //custom-theme -->
<link href="${pageContext.request.contextPath }/css/cssh/bootstrap.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath }/css/cssh/JiSlider.css"
	rel="stylesheet">
<%-- <link href="${pageContext.request.contextPath }/css/cssh/style.css" rel="stylesheet" type="text/css" media="all" /> --%>
<link
	href="${pageContext.request.contextPath }/css/cssh/font-awesome.css"
	rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<script type="text/javascript">
	new WOW().init();
</script>

</head>

<body>
	<a href="${pageContext.request.contextPath }/detail/tostratelist?beat_id=${detailO.beat_id }"><div style="position: fixed;right: 0px;height: 100px;width:25px;background-color:#e94e38;margin-top:20%;border-radius:2px; ">
	<center style="font-size: 20px;line-height: 25px;color:#fff">查看攻略</center>
	</div></a>
	<!-- 获取区域id -->
	<input type="hidden" value="${detailO.beat_id }" id="beat_id">
	<!-- 从session获取用户id -->
	<input type="hidden" value="${sessionScope.user.user_id }" id="user_id">  
	<!-- 从session获取用户名称 -->
	<input type="hidden" value="${sessionScope.user.user_name }" id="user_name1">  
	<!-- 从session获取用户头像 -->
	<input type="hidden" value="${sessionScope.user.headimg }" id="user_headimg">  
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
	
	<div style="width:100%;height:410px;">
		<img src="${pageContext.request.contextPath }/upload/${detailO.beat_img }"
			style="width:100%;height:100%;z-index:2">
		<div
			style="width:200px;height:400px;margin-top: -400px;margin-left:30px;">
			<h5 style="color:#fff;writing-mode:tb-rl;writing-mode:vertical-lr;line-height: 20px">${detailO.beat_introduce }</h5>
		</div>
	</div>
	<div class="living_middle">
		<div class="container">
			<div id="attrDiv" class="entertain_box wow fadeInLeft" data-wow-delay="0.4s">
				<div class="col-md-3 grid_box">
					<a href="${pageContext.request.contextPath }/images/imagesh/p1.jpg"
						class="swipebox" title="Image Title"> <img style="width: 255px;height: 180px"
						src="${pageContext.request.contextPath }/images/imagesh/p1.jpg"
						class="img-responsive" alt=""><span class="zoom-icon"></span></a>
					<div class="grid_box2">
						<h4><a href="#">长沙</a></h4>
						<p>2200人查看过</p></div>
				</div>
				<div class="clearfix"></div>
			</div>

		</div>
	</div>
	<div style="width:1200px;height: 20px;background-color: #ccc;text-align: center;margin: auto"><span id="commentcount">0</span>条评论向你袭来</div>
	<div id="beatcommentdiv" style="width:1200px;margin: auto;background-color:#fff">
		
	</div>
		
	<div style="width: 1200px;height: 22px;margin:auto;">
		<div id="lookMore" style="width:60px;height: 20px;border: 1px #ccc solid;margin: auto;margin-top: 2px">查看更多</div>
	</div>
	<div style="width: 1200px;height: 70px;margin: auto;background-color: #ccc;overflow: hidden">
		<textarea id="txt" style="resize:none;"  rows="2" cols="165" placeholder="说点什么吧"></textarea>
		<input id="comment" style="float: right;color: blue" type="button" value="评论">
	</div>
 	<div class="footer">
   	<div class="container">
   	 <div class="footer_top">
   	   <h3>Subscribe to our newsletter</h3>
   	   <form>
		<span>
			<i><img src="/twelveTravel/images/imagesh//mail.png" alt=""></i>
		    <input type="text" value="Enter your email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter your email';}">
		    <label class="btn1 btn2 btn-2 btn-2g"> <input name="submit" type="submit" id="submit" value="Subscribe"> </label>
		    <div class="clearfix"> </div>
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
			  <li><a href=""> <i class="fb"> </i> </a></li>
			  <li><a href=""><i class="tw"> </i> </a></li>
			  <li><a href=""><i class="google"> </i> </a></li>
			  <li><a href=""><i class="u_tube"> </i> </a></li>
		 	</ul>
		 	<div class="copy wow fadeInRight" data-wow-delay="0.4s">
              <p>Copyright &copy; 2014.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
	        </div>
		  </div>
		  <div class="clearfix"> </div>
	   </div>
      </div>
   </div>



</body>
</html>
