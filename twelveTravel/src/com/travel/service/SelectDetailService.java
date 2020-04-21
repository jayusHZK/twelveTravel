package com.travel.service;

import java.util.List;

import com.travel.po.Attractions;
import com.travel.po.ResultPage;

public interface SelectDetailService {
	//根据景点名和地点查询景点
	ResultPage selectDetail(Integer index,String find);
	//根据景点热度给出推荐
	List<Attractions> getAttractionsByhot();
}
