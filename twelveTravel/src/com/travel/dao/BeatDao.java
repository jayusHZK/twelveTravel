package com.travel.dao;

import java.util.List;

import com.travel.po.Beat;

public interface BeatDao {
	//获取城市的一个集合
	List<Beat> getBeatList();
}
