package com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.po.ResultPage;
import com.travel.service.ChangeAttractionsService;

@Controller
@RequestMapping("/changeattractions")
public class ChangeAttractionsController {

	@Autowired
	private ChangeAttractionsService changeAttractionsService;
	@RequestMapping("togetattractionslist")
	public String togetActionslist(){
		return "/comment/comment";
		
	}
	@ResponseBody
	@RequestMapping("/getattractionstlist")
	public ResultPage getAttractionstList(Integer index,String attractions_name,String beat_name){
		return changeAttractionsService.getAttractionstList(index, attractions_name, beat_name);
	}
}
