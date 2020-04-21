package com.travel.service;

import java.util.List;
import java.util.Map;

import com.travel.po.Beat;
import com.travel.po.Country;
import com.travel.po.Province;
import com.travel.po.Result;
import com.travel.po.ResultPage;
import com.travel.vo.BeatVO;


public interface ChangeDetailService {
	//根据id获取区域
	Beat getBeatById(Integer beat_id);
	//添加区域
	int toaddbeat(Beat beat);
	//获取省份的集合
	Result getProvinceList(Integer country_id);
	//查询国家
	List<Country> getCountryList();
	//分页
	ResultPage getBeatList(Integer index,BeatVO vo);
	//获取每一页的条数
	List<Beat> getBeatListByIndex(Object obj);
	//删除
	 int delBeat(Integer beat_id);
	 //根据省份id获取区域
	 Result getBeatList1(Integer province_id);


}
