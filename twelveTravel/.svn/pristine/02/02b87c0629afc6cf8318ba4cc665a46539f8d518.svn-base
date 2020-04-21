package com.travel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.travel.po.Beat;
import com.travel.po.Country;
import com.travel.po.Province;
import com.travel.vo.BeatVO;
public interface ChangeDetailDao {
	int toaddbeat(Beat beat);

	Beat getBeatById(Integer beat_id);

	List<Beat> getBeatList1(Integer province_id);
	
	List<Province> getProvinceList(Integer country_id);
	
	List<Country> getCountryList();
	
	List<BeatVO>   getBeatList(BeatVO vo);
	
	int delBeat(Integer beat_id);
	
	Beat  getBeatInfo(Beat  beat);
}
