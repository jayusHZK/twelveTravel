package com.travel.dao;

import java.util.List;
import java.util.Map;

import com.travel.po.AttrComment;
import com.travel.po.Beat;
import com.travel.po.BeatComment;
import com.travel.po.Country;
import com.travel.po.Page;
import com.travel.po.Province;
import com.travel.po.Strate;
import com.travel.po.StrateComment;

public interface StrateDao {
	//根据城市id获取城市详情
	Beat getBeatByID(Integer beat_id);
	//添加攻略
	int addStrate(Map map);
	//获取国家数据 用作分页查询
	List<Country> getCountryList();
	//根据国家id获取其下属省份
	List<Province> getProvince(Integer country_id);
	//根据省份id获取其下属城市
	List<Beat> getBeat(Integer beat_id);
	//获取攻略数据总数
	int getStrateCount(Map map);
	//分页查询
	List<Strate> getStrateList(Map map);
	//删除攻略
	int deleteStrate(Integer strate_id);
	//获取区域评论总数
	int getBeatCommentCount(Map map);
	//获取区域评论
	List<BeatComment> getBeatCommentList(Map map);
	//删除区域评论
	int deleteBComment(Integer comment_id);
	//获取景点评论
	List<AttrComment> getAttrCommentList(Map map);
	//获取景点评论总数
	int getAttrCommentCount(Map map);
	//删除景点评论
	int deleteAComment(Integer comment_id);
	//获取攻略评论
	List<StrateComment> getStrateCommentList(Map map);
	//获取攻略评论总数
	int getStrateCommentCount(Map map);
	//删除攻略评论
	int deleteSComment(Integer comment_id);
	
}
