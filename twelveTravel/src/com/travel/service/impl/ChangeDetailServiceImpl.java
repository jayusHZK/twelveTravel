package com.travel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.dao.ChangeDetailDao;
import com.travel.po.Beat;
import com.travel.po.Country;
import com.travel.po.Province;
import com.travel.po.Result;
import com.travel.po.ResultPage;
import com.travel.service.ChangeDetailService;
import com.travel.vo.BeatVO;

@Service
public class ChangeDetailServiceImpl implements ChangeDetailService {
	@Autowired
	private ChangeDetailDao detailDao;
	/***
	 * 根据id获取区域
	 */
	@Override
	public Beat getBeatById(Integer beat_id) {
		// TODO Auto-generated method stub
		return detailDao.getBeatById(beat_id);
	}
	
	
	
	/***
	 *  添加区域
	 */
	@Override
	public int toaddbeat(Beat beat) {
		
		return detailDao.toaddbeat(beat);
	}
	/**
	 * 根据省份id获取区域
	 * 
	 */
	@Override

	public Result getBeatList1(Integer province_id) {
		Result r=new Result();
		r.setMsg(detailDao.getBeatList1(province_id));
		return r;
	}
	/**
	 * 获取省份的集合
	 * 
	 */
	@Override
	public Result getProvinceList(Integer country_id) {
		// TODO Auto-generated method stub
		Result r=new Result();
		r.setMsg(detailDao.getProvinceList(country_id));
		return r;
	}
	/***
	 * 查询国家
	 */
	@Override
	public List<Country> getCountryList() {
		// TODO Auto-generated method stub
		return detailDao.getCountryList();
	}
	/**
	 * 分页查询
	 * @param index 当前第几页
	 * @param BeatVO 前台查询VO  {@link BeatVO}
	 * @说明:利用mybaits 插件的时候需要导入包pagehelper,只需要传入你的查询语句,当前第几页 每页多少条数据 .工具包自动帮助分页.不需要侵入到你的查询语句
	 */
	public ResultPage getBeatList(Integer index, BeatVO  vo) {
		//这个是你们定义的ResultPage
		ResultPage rp=new ResultPage();
		
		PageHelper.startPage(index, 10); //传入当前第几页,每页显示多少行
		
		List<BeatVO> list = detailDao.getBeatList(vo); // 获取数据同时传入待查询的条件

		PageInfo<BeatVO> p = new PageInfo<BeatVO>(list); // 实例化分页对象  通过此对象你可以取到当前表的任何数据 ,例如p.getTotal() 总条数,上一页,下一页等参数

		//组装ResultPage
		rp.setSize(10);  
		rp.setIndex(p.getPages());
		rp.setCount(p.getSize());
		rp.setPageCount(p.getPageSize());
		rp.setObj(p.getList());
		/**
		不需要这样计算,直接利用mbatis分页插件进行计算
		rp.setSize(10);
		rp.setIndex(index);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", (index-1)*rp.getSize());
		map.put("end",rp.getSize());
		map.put("beat_name", beat_name);
		map.put("province_name", province_name);
		rp.setObj(detailDao.getBeatListByIndex(map));
		
		rp.setCount(detailDao.getBeatListCount(map).intValue());
		
		rp.setPageCount((int)Math.ceil((double)rp.getCount()/rp.getSize()));
		 */
		return rp;
	}
	/**
	 * 删除
	 * 
	 */
	@Override
	public int delBeat(Integer beat_id) {
		
		return detailDao.delBeat(beat_id);
	}
	/***
	 * 获取每一页的条数
	 */
	
	@Override
	public List<Beat> getBeatListByIndex(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
