<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加评论</title>
    <link href="/twelveTravel/css/style.css" rel="stylesheet" type="text/css" />
    <script type='text/javascript' src='/twelveTravel/js/jquery-1.10.2.js'></script>
    <script type='text/javascript' src='/twelveTravel/js/ajaxfileupload.js'></script>
  </head>
  
  <body>
    
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="/twelveTravel/changedetail/toecono" method="post"  onsubmit="return check()"  >
    <ul class="forminfo">
     <li><label>国家</label><select id="cou" class="dfinput" style="width: 100px" name=""  > 
		<option>请选择</option>
		<c:forEach items="${conlist}" var="item">
     		<option value="${item.country_id}">${item.country_name}</option>
     	</c:forEach>     	
    </select>
    </li>
    
    <li><label>省</label><select id="pro" class="dfinput" style="width: 100px" name="province_id"> 
		 <option>请选择</option>	
    </select>
    <!--  
     <li><label>城市</label><select id="beat" class="dfinput" style="width: 100px" name="beat_name"> 

	</select>
    </li>
    -->
   
    

      <li><label>城市</label>
   <input id="beat" class="difinput" style="width: 100px;height:30px; border: 1px solid blue; " name="beat_name" >
     
</li>
    <li><label>内容</label><textarea rows="10" cols="50" name="beat_introduce" style="border: 1px #ccc solid;red"></textarea></li>
     
     <li>
     	<label>图片</label>
     	<input name="fileList" id="fileList" type="file" class="" /> 
     	<input type="button" value="确认上传"class="btn" id="upload" />
		<input type="hidden" name="beat_img" id="beat_img"/>				
	</li>
    <input type="hidden" name="beat_id" value="${beatInfo.beat_id }" />
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>
    
    
    <script type="text/javascript">
    $(function(){
    $(":checkbox").click(function(){
    	$(this).attr("checkbox",true);//设置当前选中的checkbox状态为checkbox
    	$(this).siblings().attr("checkbox",false);//设置当前选中的checkbox同级(兄弟级)其他checkbox状态为未选中
    })
    })
    	function uploadimg(uploadFile){
    		$.ajaxFileUpload({
    			url:"/twelveTravel/file/upload",
    			type:"post",
    			dataType:"text",
    			fileElementId:"fileList",//表示上传文件input的id
    			secureuri:false,//表示不已安全协议发送
    			success:function(data){
    				console.log(data);
    				var json=data.replace(/<.*?>/ig,"");
    				var newdata=JSON.parse(json);
    				if(newdata.code==200){
    					alert("上传成功!");
    					$("[name='beat_img']").val(newdata.msg);
    				}else{
    					alert("失败");
    				}
    			}
    		});
    	}
    	
         //下拉国家触发事件
    	$("#cou").change(function(){
    		var country_id=$(this).val();
    		
    		conuntryChange(country_id);
    	})
    	
		//下拉省份触发事件
		/**
    	$("#pro").change(function(){
    		var beat_id=$(this).val();
    		beatChange(beat_id);
    	})
    	**/

   
	    //文件上传 校验
    	function  check(){
    	  if($("#beat_img").val()==undefined||$("#beat_img").val()==''){
	    	   alert("请先选择文件进行上传!")
	    	   return  false;
	    	  
	    	}
    	 
    	}
    	
    	
			//国家-省份  级联
	    	function  conuntryChange(id){
	    	   		$.ajax({
					url:"/twelveTravel/changedetail/toaddprov",
					data:{country_id:id},
					type:"get",
					dataType:"json",
					success:function(data){
						console.log(data);
						var html="";
						html+="<option>请选择</option>";
						$(data.msg).each(function(){
						    
							 html+="<option value="+this.province_id+">"+this.province_name+"</option>";
						});
						$("#pro").empty().append(html);
						//当更换国家的时候   城市需要清除
					    $("#beat").val('');
						
						}
						
						});
	    	
	    	}
	    	//省-城市级联
	    	function  beatChange(id){
	    	   		$.ajax({
					url:"/twelveTravel/changedetail/toaddbeatv",
					data:{province_id:id},
					type:"get",
					dataType:"json",
					success:function(data){
						console.log(data);
						var html="";
	
						html+="<option>请选择</option>";
						$(data.msg).each(function(){
							 html+="<option value="+this.beat_id+">"+this.beat_name+"</option>";
						});
					
						$("#beat").empty().append(html);
					
						
						}
	
	
					});
		    	}
	    	
	    /**
    	    	function  conuntryChange(id){
    	   		$.ajax({
				url:'/twelveTravel/changedetail/toaddprov',
				data:{country_id:id},
				type:'get',
				dataType:'json',

				success:function(data){
					console.log(data);
					var html="";

					html+="<option>请选择</option>";
					$(data.msg).each(function(){
						 html+="<option value="+this.beat_id+">"+this.beat_name+"</option>";
					});

					html+="<option>请选择</option>";
					$(data.msg).each(function(){
						 html+="<option value="+this.province_id+">"+this.province_name+"</option>";
					});
					$("#pro").empty().append(html);
				

					
					$("#beat").empty().append(html);
				
					
					}
					
					});
    	
    			}
    			
    			**/
     //var beat_id="${beatInfo.beat.beat_id}";
    ///	#$("#ba").val(beat_id);
    	//#var province_id="${beatInfo.provunce.province_id}";
    	//#$("#pro").val(province_id);
    	//var country_id="${beatInfo.country.country_id}"
    	//#$("#cou").val(country_id);

    	
    	$(function(){
    		$("#upload").click(function(){
    			var id=$(this).data("id");
    			uploadimg(id);
    		});
    	});
    
    </script>
  </body>
</html>
