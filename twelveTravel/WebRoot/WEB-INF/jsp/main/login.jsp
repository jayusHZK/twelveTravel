<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
   	<link href="/twelveTravel/css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
	<script src="/twelveTravel/js/cloud.js" type="text/javascript"></script>
	
	<script language="javascript">
		$(function(){
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	    });  
	});  
	</script> 
  </head>
  
  <body style="background-color:#1c77ac; background-image:url(/twelveTravel/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    
    <form action="${pageContext.request.contextPath }/user/login" method="post">
	    <ul>
	    <li><input name="user_name" type="text" class="loginuser" value="" /></li>
	    <li><input name="password" type="password" class="loginpwd" value="" /></li>
	    <li><input  type="submit" class="loginbtn" value="登录"   /></li>
	    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  2013  .com 仅供学习交流，勿用于任何商业用途</div>
</body>
</html>
