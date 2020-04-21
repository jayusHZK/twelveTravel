package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.dao.SelectDetailDao;
import com.travel.po.Attractions;
import com.travel.po.ResultPage;
import com.travel.service.SelectDetailService;
@Service
public class SelectDetailServiceImpl implements SelectDetailService{
	@Autowired
	private SelectDetailDao selectDetailDao;
	/***
	 * 根据景点名和地点查询景点
	 * 
	 */
	@Override
	public ResultPage selectDetail(Integer index,String find) {
		ResultPage rp=new ResultPage();
		rp.setIndex(index);
		rp.setSize(4);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("start", (index-1)*rp.getSize());
		map.put("end", rp.getSize());
		map.put("find", find);
		rp.setObj(selectDetailDao.selectDetail(map));
		rp.setCount(selectDetailDao.getAttractionsListCount(map));
		rp.setPageCount((int)Math.ceil((double)rp.getCount()/rp.getSize()));
		return rp;
		
	}
	/***
	 * 根据景点热度给出推荐
	 * 
	 */
	@Override
	public List<Attractions> getAttractionsByhot() {
		
		return selectDetailDao.getAttractionsByhot();
	}
	
}
