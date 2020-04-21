package com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.po.Page;
import com.travel.po.Result;
import com.travel.po.Strate;
import com.travel.service.DetailService;
import com.travel.util.TimeConverter;

@Controller
@RequestMapping("/detail")
/***
 * 景点详情controller
 * @author hzk
 *
 */
public class DetailController {
	@Autowired
	private DetailService detailService;
	
	@RequestMapping("/tobeat")
	/***
	 * 获取区域详情
	 * @param beat_id 区域id
	 * @param m 
	 * @return
	 */
	public String toAttrctions(Integer beat_id,Model m){
		m.addAttribute("detailO", detailService.getBeatByID(beat_id));
		return "/detail/attractions";
	}
	@ResponseBody
	@RequestMapping("/getattrlist")
	/***
	 * ajax获取区域景点
	 * @param beat_id 区域id
	 * @return
	 */
	public Result getAttrList(Integer beat_id){
		return detailService.getAttrList(beat_id);
	}
	@ResponseBody
	@RequestMapping("/getbeatcomment")
	/***
	 * 获取区域评论
	 * @param beat_id
	 * @return
	 */
	public Result getBeatComment(Integer beat_id,Integer index){
		return detailService.getBeatComment(beat_id, index);
	}
	/***
	 * 添加景点评论
	 * @param beat_id 景点id
	 * @param user_id 用户id
	 * @param comment 评论内容
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addbeatcomment")
	public Result addBeatComment(Integer beat_id,Integer user_id,String comment){
		return detailService.addBeatComment(beat_id, user_id, comment);
	}
	@RequestMapping("/toattD")
	/***
	 * 进入景点
	 * @param att_id 景点id
	 * @return
	 */
	public String toAttractionss(Integer attr_id,Model m){
		m.addAttribute("attrO", detailService.getAttrByID(attr_id));
		return "/detail/beat";
	}
	@RequestMapping("/getattrc")
	@ResponseBody
	/***
	 * 获取景点评论
	 * @param attr_id 景点id
	 * @param index 当前页码
	 * @return
	 */
	public Result getAttrComment(Integer attr_id,Integer index){
		return detailService.getAttrCommentByID(attr_id, index);
	}
	@RequestMapping("/tostratelist")
	/***
	 * 进入攻略列表页面
	 * @param beat_id 区域id 
	 * @param m
	 * @return
	 */
	public String toStrate(Integer beat_id,Model m){
		m.addAttribute("beatO", detailService.getBeatByIDS(beat_id));
		return "/detail/Stratelist";
	}
	
	@RequestMapping("/addattrcomment")
	@ResponseBody
	/***
	 * 添加景点评论
	 * @param attr_id 景点id
	 * @param user_id 用户id
	 * @param comment 评论内容
	 * @return
	 */
	public Result addAttrComment(Integer attr_id,Integer user_id,String comment){
		return detailService.addAttrComment(attr_id, user_id, comment);
	}
	@RequestMapping("/getstratec")
	@ResponseBody
	/***
	 * 获取攻略评论
	 * @param strate_id 攻略id
	 * @param index 当前页码
	 * @return
	 */
	public Result getStrateComment(Integer strate_id,Integer index){
		return detailService.getStrateComment(strate_id, index);
	}
	/***
	 * 添加攻略评论
	 * @param strate_id 
	 * @param user_id
	 * @param comment
	 * @return
	 */
	@RequestMapping("/addstratecomment")
	@ResponseBody
	public Result addStrateComment(Integer strate_id,Integer user_id,String comment){
		return detailService.addStrateComment(strate_id, user_id, comment);
	}
	
	@RequestMapping("/getstratebybeatid")
	@ResponseBody
	/***
	 * 获取区域所有攻略
	 * @param beat_id 区域id
	 * @param index 页码
	 * @return
	 */
	public Page getStrateByBeat_id(Integer beat_id,Integer index){
		return detailService.getStrateByBeat_id(beat_id, index);
	}
	/***
	 * 根据攻略id获取攻略详情
	 * @param strate_id 攻略id
	 * @param m
	 * @return
	 */
	@RequestMapping("/tostrate")
	public String toStrate1(Integer strate_id,Model m){
		Strate s=detailService.getStrateBySID(strate_id);
		m.addAttribute("StrateO",s);
		return "/detail/strate";
	}
}
