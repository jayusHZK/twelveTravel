package com.travel.service;

import java.util.List;

import com.travel.po.Beat;
import com.travel.po.Country;
import com.travel.po.Page;
import com.travel.po.Result;

public interface StrateService {
	//获取城市详情 用作攻略添加
	Beat getBeatByID(Integer beat_id);
	//添加攻略
	Result addStrate(Integer user_id,Integer beat_id,String txt,String title);
	//获取国家数据 用作分页查询
	List<Country> getCountryList();
	//根据国家id获取其下属省份
	Result getProvnce(Integer country_id);
	//根据省份id获取其下属城市
	Result getBeat(Integer province_id);
	//攻略分页
	Page getStrateList(String attractions_name,Integer country_id,
			Integer province_id,Integer beat_id,Integer index);
	//删除攻略
	int deteleStrate(Integer strate_id);
	//获取区域评论分页
	Page getBeatCommmentList(Integer index,String content);
	//删除区域评论
	int deleteBComment(Integer comment_id);
	//获取景点评论分页
	Page getAttrCommmentList(Integer index,String content);
	//删除区域评论
	int deleteAComment(Integer comment_id);
	//获取攻略评论
	Page getStrateCommmentList(Integer index,String content);
	//删除攻略评论
	int deleteSComment(Integer comment_id);
}
