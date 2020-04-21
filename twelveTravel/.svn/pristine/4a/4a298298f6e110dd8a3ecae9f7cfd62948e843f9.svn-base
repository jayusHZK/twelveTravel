<%@ page language='java' import='java.util.*' pageEncoding='utf-8'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>
<html>
  <head>

    <title>景区列表</title>
	<link href='/twelveTravel/css/style.css' rel='stylesheet' type='text/css' />
	<script type='text/javascript' src='/twelveTravel/js/jquery-1.10.2.js'></script>
<style type="text/css">
		.myul{height:35px;margin-left: 30px;width:700px;float:left}
		.myul li{
			float:left;height:35px;
			line-height: 35px;
			font-size: 13px;
		}
		.myul li input,select{height:35px;
			line-height: 35px;
			border:1px solid #ccc;
			}
	</style>

  </head>
  
  <body>

	<div class='place'>
    <span>位置：</span>
    <ul class='placeul'>
    <li><a href='#'>首页</a></li>
    <li><a href='#'>数据表</a></li>
    <li><a href='#'>基本内容</a></li>
    </ul>
    </div>
    
    <div class='rightinfo'>
    
    <div class='tools'>
    	<ul class='toolbar'>
        <li class='click'><a href="/twelveTravel/changedetail/toaddbeat1"><span><img src='/twelveTravel/images/t01.png' /></span>添加</a></li>
        </ul>
         <ul class="myul">
        	<li style="margin-left: 5px">景点名称</li>
        	<li><input id="attractions_name" type="text"></li>
        	<li style="margin-left: 5px">景点区域</li>
        	<li><input id="beat_name" type="text"></li>
        </ul>
        	
        
        <ul class='toolbar1'>
        <li id="find"><span><img src='/twelveTravel/images/t03.png' /></span>查询</li>
        </ul>
    
    </div>
    
    
    <table class='tablelist'>
    	<thead>
    	<tr>
        <th>编号</th>
        <th>景区名称</th>
        <th>所属区域</th>
        <th>图片</th>
        <th>所属地</th>
        <th>是否热门</th>
        <th>景点简介</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody id="boxcontent">
        
  
        </tbody>
    </table>
    
   
    <div class='pagin'>
    	<div class='message'>共<i class='blue' id="count">1256</i>条记录，当前显示第&nbsp;<i class='blue' id="index">2</i>页</div>
        <ul class='paginList'>

        <li class='paginItem current'><a href='javascript:;' id="first">首</a></li>
        <li class='paginItem'><a href='javascript:;' id="before">上</a></li>
        <li class='paginItem'><a href='javascript:;' id="next">下</a></li>
        <li class='paginItem'><a href='javascript:;' id="last">末</a></li>

        </ul>
    </div>
    
    
    <div class='tip'>
    	<div class='tiptop'><span>提示信息</span><a></a></div>
        
      <div class='tipinfo'>
        <span><img src='/twelveTravel/images/ticon.png' /></span>
        <div class='tipright'>
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class='tipbtn'>
        <input name='' type='button'  class='sure' value='确定' />&nbsp;
        <input name='' type='button'  class='cancel' value='取消' />
        </div>
    
    </div>
    </div>
    
    <script type='text/javascript'>
		$('.tablelist tbody tr:odd').addClass('odd');
		
		//查询用户分页的方法   index表示页码
		function getdata(index){
			var content={index:index};
			content.attractions_name=$("#attractions_name").val();
			content.beat_name=$("#beat_name").val();
			$.ajax({
				url:"/twelveTravel/changeattractions/getattractionstlist",
				data:content,
				type:"get",
				dataType:"json",
				success:function(data){
					console.log(data);
					var html="";
					//循环服务器返回的数据    拼接html
					$(data.obj).each(function(){
						html+="<tr> ";
						html+="<td>"+this.attractions_id+"</td>";
						html+="<td>"+this.attractions_name+"</td>";
						html+="<td>"+this.beat_name+"</td>";
						html+="<td><img width='100' height='100' src='/twelveTravel/images/upload/"+this.attractions_img+"' /></td>";
						html+="<td>"+this.attractions_name+"</td>";
						html+="<td>"+getHotNum(this.hotNum)+"</td>";						
						html+="<td atttractions_introduce='"+this.atttractions_introduce+"'>"+(this.atttractions_introduce.length>20?(this.atttractions_introduce.substring(0,20)+"..."):this.atttractions_introduce)+"</td>";
						html+="<td><a href='/twelveTravel/changeattractions/togetattractionslist?attractions_id="+this.attractions_id+"' class='tablelink'>修改</a><a href='/twelveTravel/changeattractions/?attractions_id="+this.attractions_id+"' class='tablelink del'>修改</a></td>";
						html+="</tr> ";
					});
					//设置总条数
					$("#count").text(data.count);
					//设置当前页
					$("#index").text(data.index);
					//将拼接的html添加到对应的容器中去
					$("#boxcontent").empty().append(html);
					//设置首页的页码
					$("#first").data("index",1);
					//设置最后一页的页码
					$("#last").data("index",data.pageCount);
					//设置上一页的页码
					$("#before").data("index",(data.index==1?1:(data.index-1)));
					//设置下一页的页码
					$("#next").data("index",(data.index==data.pageCount?data.pageCount:(data.index+1)));
				}
			});
		}
		function getLocalTime(nS) {     
		   return new Date(parseInt(nS)*1000).toLocaleString().replace(/:\d{1,2}$/,' ');     
		}
		
		function getHotNum(hotNum){
			if(hotNum==0){
			return "冷门";
			}else{
			return "热门";
			}
			
		
		
		}
		$(function(){
			getdata(1);
			
			//分页按钮的点击事件
			$("#first,#before,#last,#next").click(function(){
				var index=$(this).data("index");//获取分页方法中设置的页码值
				getdata(index);//将对应的页码值传入分页的方法进行分页
			});
			
			$("#find").click(function(){
				getdata(1);
			});
		});
	</script>
  </body>
</html>
