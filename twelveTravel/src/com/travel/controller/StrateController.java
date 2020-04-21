package com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.po.Page;
import com.travel.po.Result;
import com.travel.service.StrateService;


@Controller
@RequestMapping("/strate")
public class StrateController {
	@Autowired
	private StrateService strateService;
	/***
	 * 进入添加攻略页面
	 * @param m
	 * @param beat_id 城市id
	 * @return
	 */
	@RequestMapping("/toaddstrate")
	public String toAddStrate(Model m,Integer beat_id){
		m.addAttribute("beatO", strateService.getBeatByID(beat_id));
		return "/strate/addStrate";
	}
	/***
	 * 
	 * @param user_id 用户id
	 * @param beat_id 城市id
	 * @param txt 攻略内容
	 * @return
	 */
	@RequestMapping("/addstrate")
	@ResponseBody
	public Result addStrate(Integer user_id,Integer beat_id,String txt,String title){
		return strateService.addStrate(user_id, beat_id, txt,title);
	}
	/***
	 * 进入攻略分页界面 并把国家数据传过去 用作查询
	 * @return
	 */
	@RequestMapping("/tostratelist")
	public String toStrateList(Model m){
		m.addAttribute("countryO", strateService.getCountryList());
		return "/strate/strateList";
	}
	/***
	 * 根据国家id获取其下属省份
	 * @param country_id 国家id
	 * @return
	 */
	@RequestMapping("/getprovince")
	@ResponseBody
	public Result getProvince(Integer country_id){
		return strateService.getProvnce(country_id);
	}
	/***
	 * 根据省份id获取其下属城市
	 * @param province_id
	 * @return
	 */
	@RequestMapping("/getbeat")
	@ResponseBody
	public Result getBeat(Integer province_id){
		return strateService.getBeat(province_id);
	}
	/***
	 * 攻略分页
	 * @param attractions_name 用户输入搜索关键字
	 * @param country_id 国家id
	 * @param province_id 省份id
	 * @param beat_id 城市id
	 * @param index 当前页码
	 * @return
	 */
	@RequestMapping("/getstratelist")
	@ResponseBody
	public Page getStrateList(String attractions_name,Integer country_id,
			Integer province_id,Integer beat_id,Integer index){
		return strateService.getStrateList(attractions_name, country_id, province_id, beat_id, index);
	}
	/***
	 * 删除攻略
	 * @param strate_id 攻略id
	 * @return
	 */
	@RequestMapping("/detelestrate")
	public String detaleStrate(Integer strate_id){
		strateService.deteleStrate(strate_id);
		return "/strate/strateList";
	}
	/***
	 * 进入区域评论分页
	 * @return
	 */
	@RequestMapping("/tobclist")
	public String toBeatCommentList(){
		return "/comments/bclist";
	}
	/***
	 * 进入景点评论分页
	 * @return
	 */
	@RequestMapping("/toaclist")
	public String toAttrCommentList(){
		return "/comments/aclist";
	}
	/***
	 * 进入攻略评论分页
	 * @return
	 */
	@RequestMapping("/tosclist")
	public String toStrateCommentList(){
		return "/comments/sclist";
	}
	/***
	 * 获取区域评论
	 * @param index 页码
	 * @param content 搜索内容
	 * @return
	 */
	@RequestMapping("/getbclist")
	@ResponseBody
	public Page getBeatCommentList(Integer index,String content){
		return strateService.getBeatCommmentList(index, content);
	}
	/***
	 * 删除区域评论
	 * @param comment_id 评论id
	 * @return
	 */
	@RequestMapping("/detelebcomment")
	public String deleteBComment(Integer comment_id){
		strateService.deleteBComment(comment_id);
		return "/comments/bclist";
	}
	/***
	 * 获取景点评论
	 * @param index 页码
	 * @param content 搜索内容
	 * @return
	 */
	@RequestMapping("/getaclist")
	@ResponseBody
	public Page getAttrCommentList(Integer index,String content){
		return strateService.getAttrCommmentList(index, content);
	}
	/***
	 * 删除景点评论
	 * @param comment_id 评论id
	 * @return
	 */
	@RequestMapping("/deteleacomment")
	public String deleteAComment(Integer comment_id){
		strateService.deleteAComment(comment_id);
		return "/comments/aclist";
	}
	/***
	 * 获取攻略评论
	 * @param index 页码
	 * @param content 搜索内容
	 * @return
	 */
	@RequestMapping("/getsclist")
	@ResponseBody
	public Page getStrateCommentList(Integer index,String content){
		return strateService.getStrateCommmentList(index, content);
	}
	/***
	 * 删除攻略评论
	 * @param comment_id 评论id
	 * @return
	 */
	@RequestMapping("/detelescomment")
	public String deleteStrateComment(Integer comment_id){
		strateService.deleteSComment(comment_id);
		return "/comments/sclist";
	}
}

