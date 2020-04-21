package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.dao.StrateDao;
import com.travel.po.Beat;
import com.travel.po.Country;
import com.travel.po.Page;
import com.travel.po.Result;
import com.travel.po.Strate;
import com.travel.po.User;
import com.travel.service.StrateService;

@Service
public class StrateServiceImpl implements StrateService {
	@Autowired
	private StrateDao strateDao;
	//根据id获取城市详情
	@Override
	public Beat getBeatByID(Integer beat_id) {
		// TODO Auto-generated method stub
		return strateDao.getBeatByID(beat_id);
	}

	@Override
	//添加攻略
	public Result addStrate(Integer user_id, Integer beat_id, String txt,String title) {
		Result r=new Result();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("beat_id", beat_id);
		map.put("user_id", user_id);
		map.put("txt", txt);
		map.put("title", title);
		map.put("strate_time", System.currentTimeMillis()/1000);
		map.put("strategy_id", "");
		strateDao.addStrate(map);
		r.setMsg(map.get("strategy_id"));
		return r;
	}
	//获取国家数据 用作分页查询
	@Override
	public List<Country> getCountryList() {
		// TODO Auto-generated method stub
		return strateDao.getCountryList();
	}
	//根据国家id获取其下属省份
	@Override
	public Result getProvnce(Integer country_id) {
		Result r=new Result();
		r.setMsg(strateDao.getProvince(country_id));
		return r;
	}
	//根据省份id获取其下属城市
	@Override
	public Result getBeat(Integer province_id) {
		Result r=new Result();
		r.setMsg(strateDao.getBeat(province_id));
		return r;
	}
	//获取攻略集合
	@Override
	public Page getStrateList(String attractions_name, Integer country_id,
			Integer province_id, Integer beat_id, Integer index) {
		Page p=new Page();
		p.setSize(5);
		p.setIndex(index);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("content", attractions_name);
		map.put("beat_id", beat_id);
		map.put("province_id", province_id);
		map.put("country_id", country_id);
		map.put("size", p.getSize());
		map.put("start", (p.getIndex()-1)*p.getSize());
		p.setCount(strateDao.getStrateCount(map));
		p.setPageCount((int)Math.ceil((double)p.getCount()/p.getSize()));
		p.setObj(strateDao.getStrateList(map));
		return p;
	}
	//删除攻略
	@Override
	public int deteleStrate(Integer strate_id) {
		// TODO Auto-generated method stub
		return strateDao.deleteStrate(strate_id);
	}
	//获取区域评论分页
	@Override
	public Page getBeatCommmentList(Integer index, String content) {
		Page p=new Page();
		p.setSize(5);
		p.setIndex(index);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("content", content);
		map.put("size", p.getSize());
		map.put("start", (p.getIndex()-1)*p.getSize());
		p.setCount(strateDao.getBeatCommentCount(map));
		p.setPageCount((int)Math.ceil((double)p.getCount()/p.getSize()));
		p.setObj(strateDao.getBeatCommentList(map));
		return p;
	}
	//删除区域评论id
	@Override
	public int deleteBComment(Integer comment_id) {
		return strateDao.deleteBComment(comment_id);
	}
	//获取景点评论
	@Override
	public Page getAttrCommmentList(Integer index, String content) {
		Page p=new Page();
		p.setSize(5);
		p.setIndex(index);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("content", content);
		map.put("size", p.getSize());
		map.put("start", (p.getIndex()-1)*p.getSize());
		p.setCount(strateDao.getAttrCommentCount(map));
		p.setPageCount((int)Math.ceil((double)p.getCount()/p.getSize()));
		p.setObj(strateDao.getAttrCommentList(map));
		return p;
	}
	//删除景点评论
	@Override
	public int deleteAComment(Integer comment_id) {
		return strateDao.deleteAComment(comment_id);
	}
	//获取攻略评论
	@Override
	public Page getStrateCommmentList(Integer index, String content) {
		Page p=new Page();
		p.setSize(5);
		p.setIndex(index);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("content", content);
		map.put("size", p.getSize());
		map.put("start", (p.getIndex()-1)*p.getSize());
		p.setCount(strateDao.getStrateCommentCount(map));
		p.setPageCount((int)Math.ceil((double)p.getCount()/p.getSize()));
		p.setObj(strateDao.getStrateCommentList(map));
		return p;
	}
	//删除攻略评论
	@Override
	public int deleteSComment(Integer comment_id) {
		return strateDao.deleteSComment(comment_id);
	}

}
