package com.travel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.dao.MainDao;
import com.travel.po.Power_Type;
import com.travel.service.MainService;
@Service
public class MianServiceImpl implements MainService {
	@Autowired
	private MainDao mainDao;
	//获取后台主页左侧导航栏的列表
	@Override
	public List<Power_Type> getPower() {
		return mainDao.getPoser();
	}
	
}
