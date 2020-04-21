package com.travel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.po.Result;
import com.travel.po.ResultPage;
import com.travel.service.SelectDetailService;

@Controller
@RequestMapping("/selectDetail")
public class SelectDetailController {
	//从spring容器中获取类
	@Autowired
	private SelectDetailService selectDetailService;
	/***
	 * 前台推荐景点的显示
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAttractionsByhot")
	public Result getAttractionsByhot(){
		Result rs=new Result();
		rs.setMsg(selectDetailService.getAttractionsByhot());
		rs.setCode(200);
		return rs;
	}
	/***
	 * 模糊查询景点和城市
	 * @param index
	 * @param find 模糊查询的条件
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getselectDetail")
	public ResultPage getselectDetail(Integer index,String find){
		
		return selectDetailService.selectDetail(index, find);
	}
}
