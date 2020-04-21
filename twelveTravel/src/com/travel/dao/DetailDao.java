package com.travel.dao;

import java.util.List;
import java.util.Map;

import com.travel.po.AttrComment;
import com.travel.po.Attractions;
import com.travel.po.Beat;
import com.travel.po.BeatComment;
import com.travel.po.Strate;
import com.travel.po.StrateComment;

public interface DetailDao {
	////根据id获取区域详情
	Beat getBeatByID(Integer beat_id);
	//获取区域内景点
	List<Attractions> getAttrList(Integer beat_id);
	//每进一次区域页面 此区域浏览量+1
	int beatHotNum(Integer beat_id);
	//查询出评论总数 用作分页
	int getCommentCount(Integer beat_id);
	//获取区域评论
	List<BeatComment> getBeatComment(Map map);
	//添加区域评论
	int addBeatComment(Map map);
	//添加区域评论总数
	int addBeatCommentCount(Integer beat_id);
	//添加景点评论总数
	int addAttrCommentCount(Integer attr_id);
	//获取景点详情
	Attractions getAttrByID(Integer attr_id);
	//添加景点热度
	int addAttrHot(Integer attr_id);
	//获取景点评论总数
	int getAttrCommentCount(Integer attr_id);
	//获取景点评论
	List<AttrComment> getAttrComment(Map map);
	//添加景点评论
	int addAttrComment(Map map);
	//进入景点攻略
	Strate getStrateByID(Integer beat_id);
	//添加攻略浏览量
	int addStrateLeadNum(Integer strate_id);
	//获取攻略评论总数
	int getStrateCommentCount(Integer attr_id);
	//获取攻略评论
	List<StrateComment> getStrateComment(Map map);
	//添加攻略评论
	int addStrateComment(Map map);
	//添加攻略评论总数
	int addStrateCommentNum(Integer strate_id);
	//攻略列表页获取区域详情
	Beat getBeatByIdS(Integer beat_id);
	//获取区域攻略总数
	int getBeatStrateCount(Integer beat_id);
	//获取攻略列表分页
	List<Strate> getStrateListByBeat_id(Map map);
	//根据攻略id获取攻略
	Strate getStrateBySID(Integer strate_id);
	
}
