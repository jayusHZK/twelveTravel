package com.travel.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.po.Attractions;
import com.travel.po.Beat;
import com.travel.po.Country;
import com.travel.po.Page;
import com.travel.po.Province;
import com.travel.po.Result;
import com.travel.po.User;
import com.travel.service.AttractionService;
import com.travel.service.BeatService;
import com.travel.service.ChangeDetailService;

@Controller
@RequestMapping("/attractions")
/***
 *   
 * @author cgy
 * 景点controller
 *
 */
public class AttractionController {

	@Autowired
	private AttractionService attractionService;

	@Autowired
	private BeatService beatService;

	@Autowired
	private ChangeDetailService detailService;

	/***
	 * 添加景点
	 * @param attractions  景点实体
	 * @param beat_id  城市id
	 * @param province_id  省份id
	 * @param country_id  国家id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addattractions")
	public Result addAttractions(Attractions attractions, Integer beat_id,Integer province_id, Integer country_id) {
		return attractionService.addAttractions(attractions, beat_id,province_id, country_id);
	}

	/***
	 * 修改景点
	 * @param attractions  景点实体
	 * @param beat_id  城市id
	 * @param province_id  省份id
	 * @param country_id  国家id
	 * @param attractions_id 景点id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editattractions")
	public Result editAttractions(Attractions attractions, Integer beat_id,Integer province_id, Integer country_id,@Param("attractions_id") Integer attractions_id) {
		attractions.setAttractions_id(attractions_id);
		return attractionService.editAttractions(attractions, beat_id,province_id, country_id);
	}

	/**
	 * 跳转到添加景点界面
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping("/toaddattractions")
	public String addAttration(Model m, Integer attractions_id,Integer beat_id, Integer province_id, Integer country_id) {
		if (attractions_id != null && attractions_id != 0) {
			Attractions attrations = attractionService.getAttractionsById(attractions_id);
			m.addAttribute("attractionsInfo", attrations);
		}

		// 因为添加用户时需要指定对应的区域 所以在加载之前应该先查询出所有的区域
		m.addAttribute("beatlist", beatService.getBeatList());
		if (beat_id != null && beat_id != 0) {
			Beat beat = detailService.getBeatById(beat_id);
			m.addAttribute("beatInfo", beat);
		}
		// 查询国家
		m.addAttribute("conlist", attractionService.getCountryList());
		// 查询省市
		m.addAttribute("prolist", attractionService.getProvinceList(country_id));
		// 查询城市
		m.addAttribute("deplist", attractionService.getBeatList1(province_id));
		return "attraction/addattractions";
	}

	/***
	 * 根据国家id查询省份
	 * @param m
	 * @param country_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toaddprov")
	public Result toAddprov(Model m, Integer country_id) {
		return detailService.getProvinceList(country_id);
	}

	/***
	 * 根据省份id查询城市
	 * @param m
	 * @param province_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toaddbeatv")
	public Result toAddBeat(Model m, Integer province_id) {
		return detailService.getBeatList1(province_id);
	}

	/**
	 * 跳转到修改景点界面
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping("/toeditattractions")
	public String editAttration(Model m, Integer attractions_id,Integer beat_id, Integer country_id, Integer province_id) {
		if (attractions_id != null && attractions_id != 0) {
			Attractions attrations = attractionService.getAttractionsById(attractions_id);
			m.addAttribute("attractionsInfo", attrations);
			m.addAttribute("id", attractions_id);
		}

		if (beat_id != null && beat_id != 0) {
			Beat beat = detailService.getBeatById(beat_id);
			m.addAttribute("beatInfo", beat);
		}
		if (country_id != null && country_id != 0) {
			Country country = attractionService.getCountryById(country_id);
			m.addAttribute("countryInfo", country);
		}
		if (province_id != null && province_id != 0) {
			Province province = attractionService.getProvinceById(province_id);
			m.addAttribute("provinceInfo", province);
		}
		// 查询国家
		m.addAttribute("conlist", attractionService.getCountryList());
		// 查询省市
		m.addAttribute("prolist", attractionService.getProvinceList(country_id));
		// 因为添加用户时需要指定对应的区域 所以在加载之前应该先查询出所有的区域
		m.addAttribute("beatlist", beatService.getBeatList());
		return "attraction/editattractions";
	}

	/***
	 * 删除景点
	 * 
	 * @param m
	 * @param attractions_id
	 * @return
	 */
	@RequestMapping("/todelattractions")
	public String delAttration(Model m, Integer attractions_id) {
		int result = attractionService.delAttractions(attractions_id);
		// 查询国家
		m.addAttribute("conlist", attractionService.getCountryList());
		// 查询省市
		m.addAttribute("prolist", attractionService.getProvinceList1());
		// 因为添加城市时需要指定对应的城市 所以在加载之前应该先查询出所有的城市
		m.addAttribute("beatlist", beatService.getBeatList());
		return "attraction/delattractions";
	}

	/**
	 * 根据页码查询景点列表
	 * 
	 * @param index
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getattractionslist")
	public Page getAttractionsList(Integer index, String attractions_name,Integer beat_id, Integer province_id, Integer country_id) {
		return attractionService.getAttractionsList(index, attractions_name,beat_id, province_id, country_id);
	}

	/**
	 * 跳转到景点分页列表页面
	 * 
	 */
	@RequestMapping("/toattractionslist")
	public String attrationList(Model m, Attractions attractions) {
		// 查询国家
		m.addAttribute("conlist", attractionService.getCountryList());
		// 查询省份
		m.addAttribute("prolist", attractionService.getProvinceList1());
		// 查询城市
		m.addAttribute("beatlist", beatService.getBeatList());		
		return "attraction/attractionslist";
	}
}
