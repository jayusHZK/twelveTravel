package com.travel.service;

import com.travel.po.Attractions;
import com.travel.po.Beat;
import com.travel.po.Page;
import com.travel.po.Result;
import com.travel.po.Strate;

public interface DetailService {
	//根据id获取区域详情
	Beat getBeatByID(Integer beat_id);
	//获取区域内景点
	Result getAttrList(Integer beat_id);
	//获取区域评论
	Result getBeatComment(Integer beat_id,Integer index);
	//添加区域评论
	Result addBeatComment(Integer beat_id,Integer user_id,String txt);
	//获取景点详情
	Attractions getAttrByID(Integer attr_id);
	//获取景点评论
	Result getAttrCommentByID(Integer attr_id,Integer index);
	//添加景点评论
	Result addAttrComment(Integer attr_id,Integer user_id,String comment);
	//进入景点攻略列表 获得区域信息
	Strate getStrateByID(Integer beat_id);
	//获取攻略评论
	Result getStrateComment(Integer strate_id,Integer index);
	//添加攻略评论
	Result addStrateComment(Integer strate_id,Integer user_id,String comment);
	//进入区域攻略列表
	Beat getBeatByIDS(Integer beat_id);
	//获取区域攻略
	Page getStrateByBeat_id(Integer beat_id,Integer index);
	//根据攻略id获取攻略详情
	Strate getStrateBySID(Integer Strate_id);
}
