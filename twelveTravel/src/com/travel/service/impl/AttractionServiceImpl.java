package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travel.dao.AttractionDao;
import com.travel.po.Attractions;
import com.travel.po.Beat;
import com.travel.po.Country;
import com.travel.po.Page;
import com.travel.po.Province;
import com.travel.po.Result;
import com.travel.po.User;
import com.travel.service.AttractionService;

@Service
public class AttractionServiceImpl implements AttractionService {

	@Autowired
	private AttractionDao attractionDao;

	@Override
	/***
	 * 修改景点
	 * @param attractions
	 * @return
	 */
	public Result editAttractions(Attractions attractions,Integer beat_id,Integer province_id,Integer country_id) {
			Result r=new Result();
			Beat beat=new Beat();
			beat.setBeat_id(beat_id);
			Province p=new Province();
			p.setProvince_id(province_id);
			Country c=new Country();
			c.setCountry_id(country_id);
			attractions.setBeat(beat);
			attractions.setProvince(p);
			attractions.setCountry(c);
			//如果景点id不等于0并且大于0的话就去执行修改景点
			if(attractions.getAttractions_id()!=0&&attractions.getAttractions_id()>0){
				r.setCode(attractionDao.editAttractions(attractions));	
			}	
			return r; 	
	
	}
	
	/***
	 * 添加景点
	 */
	public Result addAttractions(Attractions attractions,Integer beat_id,Integer province_id,Integer country_id){
		Result r=new Result();
		Beat beat=new Beat();
		beat.setBeat_id(beat_id);
		Province p=new Province();
		p.setProvince_id(province_id);
		Country c=new Country();
		c.setCountry_id(country_id);
		attractions.setBeat(beat);
		attractions.setProvince(p);
		attractions.setCountry(c);
		r.setCode(attractionDao.addAttractions(attractions));
		return r;
	}

	/***
	 * 删除景点
	 * @param attractions
	 * @return
	 */
	@Override
	public int delAttractions(Integer attractions_id) {
		return attractionDao.delAttractions(attractions_id);
	}
	

	/***
	 * 景点分页
	 * @param attractions
	 * @return
	 */
	@Override
	public Page getAttractionsList(Integer index, String attractions_name,Integer beat_id,Integer province_id,Integer country_id) {
		Page rp=new Page();
		// 根据条件查询总条数
		rp.setSize(5);
		rp.setIndex(index);	
		//根据条件查询当前页的数据
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", (index-1)*rp.getSize());
		map.put("end",rp.getSize());
		map.put("attractions_name", attractions_name);
		map.put("beat_id", beat_id);
		map.put("province_id", province_id);
		map.put("country_id", country_id);
		
		// 获取总条数
		rp.setCount(attractionDao.getAttractionsListCount(map).intValue());
		// 获取总页数
		rp.setPageCount((int)Math.ceil((double)rp.getCount()/rp.getSize()));
		// 获取每一页的条数
		rp.setObj(attractionDao.getAttractionsListByIndex(map));
		return rp;
	}

	/***
	 * 获取景点id
	 * 	@param attractions
	 * @return
	 */
	@Override

	public Attractions getAttractionsById(Integer attractions_id) {
		return attractionDao.getAttractionsById(attractions_id);
	}

	/***
	 * 查询省份
	 */
	@Override
	public List<Province> getProvinceList1() {
		return attractionDao.getProvinceList1();
	}

	/***
	 * 获取国家id
	 */
	@Override
	public Country getCountryById(Integer country_id) {
		return attractionDao.getCountryById(country_id);
	}

	/***
	 * 获取省份id
	 */
	@Override
	public Province getProvinceById(Integer province_id) {
		return attractionDao.getProvinceById(province_id);
	}

	/***
	 * 根据国家id查询省份
	 */
	@Override
	public Result getProvinceList(Integer country_id) {
		return attractionDao.getProvinceList(country_id);
	}

	/***
	 * 查询国家
	 */
	@Override
	public List<Country> getCountryList() {
		return attractionDao.getCountryList();
	}

	/***
	 * 根据省份id查询城市
	 */
	@Override
	public Result getBeatList1(Integer province_id) {
		return attractionDao.getBeatList1(province_id);
	}






}
