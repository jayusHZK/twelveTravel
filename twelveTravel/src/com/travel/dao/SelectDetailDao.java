package com.travel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.travel.po.Attractions;
import com.travel.po.Result;

public interface SelectDetailDao {
	//查询景点总条数
	int getAttractionsListCount(Map map);
	//根据景点名和地点查询景点
	List<Attractions> selectDetail(Map map);
	//根据景点热度给出推荐
	List<Attractions> getAttractionsByhot();
}
