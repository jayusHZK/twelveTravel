package com.travel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.dao.BeatDao;
import com.travel.po.Beat;
import com.travel.service.BeatService;
@Service
public class BeatServiceImpl implements BeatService{
	
	@Autowired
	private BeatDao beatDao;

	/***
	 * 查询城市
	 */
	@Override
	public List<Beat> getBeatList() {
		return beatDao.getBeatList();
	}

}
