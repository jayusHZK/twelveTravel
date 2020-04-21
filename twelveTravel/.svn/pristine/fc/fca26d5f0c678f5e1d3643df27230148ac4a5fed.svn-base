package com.travel.dao;

import java.util.List;
import java.util.Map;

import com.travel.po.Attractions;
import com.travel.po.Country;
import com.travel.po.Page;
import com.travel.po.Province;
import com.travel.po.Result;

public interface AttractionDao {

	// 添加景点
	int addAttractions(Attractions attractions);

	// 删除景点
	int delAttractions(Integer attractions_id);

	// 修改景点
	int editAttractions(Attractions attractions);

	// 获取景点id
	Attractions getAttractionsById(Integer attractions_id);

	// 获取国家id
	Country getCountryById(Integer country_id);

	// 获取省份id
	Province getProvinceById(Integer province_id);

	// 根据国家id查询省份
	Result getProvinceList(Integer country_id);

	// 根据省份id查询城市
	Result getBeatList1(Integer province_id);

	// 查询省份
	List<Province> getProvinceList1();

	// 查询国家
	List<Country> getCountryList();

	// 获取景点分页的总条数
	Long getAttractionsListCount(Map map);

	// 获取每一页的条数
	List<Attractions> getAttractionsListByIndex(Map param);
}
