package com.travel.service;

import java.util.List;

import com.travel.po.Attractions;
import com.travel.po.Country;
import com.travel.po.Page;
import com.travel.po.Province;
import com.travel.po.Result;

public interface AttractionService {

	// 添加景点
	Result addAttractions(Attractions attractions,Integer beat_id,Integer province_id,Integer country_id);
	
	// 修改景点
	Result editAttractions(Attractions attractions,Integer beat_id,Integer province_id,Integer country_id);
	
	//查询省份
	 List<Province> getProvinceList1();

	//获取景点id
	Attractions getAttractionsById(Integer attractions_id);
	
	//获取国家id
	Country getCountryById(Integer country_id);
	
	//获取城市id
	Province getProvinceById(Integer province_id);
	
	//根据国家id查询省份
	Result getProvinceList(Integer country_id);
	
	//查询国家
	List<Country> getCountryList();
	
	//根据省份id查询城市
	Result getBeatList1(Integer province_id);

	// 删除景点
	int delAttractions(Integer attractions_id);

	// 景点分页
	Page getAttractionsList(Integer index,String attractions_name,Integer beat_id,Integer province_id,Integer country_id);
}
