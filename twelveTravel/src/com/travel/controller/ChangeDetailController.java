package com.travel.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.po.Beat;
import com.travel.po.Result;
import com.travel.po.ResultPage;
import com.travel.service.ChangeDetailService;
import com.travel.vo.BeatVO;

@Controller
@RequestMapping("/changedetail")
/***
 * 	区域分页Controller
 * @author tp
 * 
 */
public class ChangeDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChangeDetailController.class);

	@Autowired
	private ChangeDetailService detailService;

	/**
	 * 区域分页
	 * @param index    当前第几页
	 * @param beat_name   区域名称
	 * @param beat_introduce  描述
	 * @return ResultPage 分页对象 {@link  ResultPage}
	 */
	@ResponseBody
	@RequestMapping(value = "/getbeatlist", produces = {"text/html;charset=UTF-8;", "application/json;" })
	public ResultPage getBeatList(Integer index, String beat_name,	String beat_introduce) {
		// 将数据映射到VO内
	
		BeatVO vo = new BeatVO();
		vo.setBeat_name(beat_name);
		vo.setBeat_introduce(beat_introduce);
		logger.info("区域查询参数:{},{}",vo.getBeat_name(),vo.getBeat_introduce());
		return detailService.getBeatList(index, vo);
	}

	@RequestMapping("/toattD")
	public String toAttrctions() {
		return "/detail/attractions";
	}

	/**
	 * 跳转至区域分页
	 * @return
	 */
	@RequestMapping("/tobeat")
	public String toBeat() {
		return "/comment/beat";
	}

	/**
	 * 跳转至区域增加页面
	 * @return
	 */
	@RequestMapping("/toaddbeat")
	public String toaddbeat() {
		return "/comment/addbeat";
	}
	
	/**
	 * 通过国家ID省份
	 * @param country_id
	 * @return Result 统一返回实体{@link Result}
	 */
	@ResponseBody
	@RequestMapping("/toaddprov")
	public Result toAddprov(Model m, Integer country_id) {
		Result result = detailService.getProvinceList(country_id);
		return result;
	}

	/**
	 * 通过省份ID查询城市
	 * @param province_id
	 * @return Result 统一返回实体{@link Result}
	 */
	@ResponseBody
	@RequestMapping("/toaddbeatv")
	public Result toAddBeat(Model m, Integer province_id) {
		return detailService.getBeatList1(province_id);
	}

	/**
	 * @Description 添加区域
	 * @author tp
	 * @param m
	 * @param beat_id
	 * @return String 跳转URL
	 */
	@RequestMapping("/toaddbeat1")
	public String toAddbeat(Model m, Integer beat_id, Integer province_id,
			Integer country_id) {
		if (beat_id != null && beat_id != 0) {
			Beat beat = detailService.getBeatById(beat_id);
			m.addAttribute("beatInfo", beat);
		}
		// 查询国家
		m.addAttribute("conlist", detailService.getCountryList());
		// 查询省市
		m.addAttribute("prolist", detailService.getProvinceList(country_id));
		// 查询城市
		//m.addAttribute("deplist", detailService.getBeatList1(province_id));
		// 跳转至添加区域页面
		return "/comment/addbeat";
	}

	/**
	 * 添加景区
	 * @author tp
	 * @param beat 区域实体 {@link Beat}
	 * @return string
	 */
	@RequestMapping(value = "/toecono", method = RequestMethod.POST)
	public String toaddcono(@ModelAttribute Beat beat) {
		beat.setCreate_date(new Date());
		int result = detailService.toaddbeat(beat);
		logger.info("添加区域返回的成功值:{}",result);
		if (result > 0) {
			return "/comment/beat";
		} else {
			return "redirect:/detail/toaddbeat1";
		}

	}

	/**
	 * 跳转到添加区域页面
	 * @param m
	 * @param province_id
	 * @return
	 */
	@RequestMapping("/tobeatList")
	public String toBeatList(Model m, Integer province_id) {
		m.addAttribute("balist", detailService.getBeatList1(province_id));
		return "/comment/addbeat";
	}
	
	/**
	 * 删除区域
	 * @param beat_id
	 * @return
	 */
	@RequestMapping("/delbeat")
	public String delBeat(Integer beat_id) {
		int result = detailService.delBeat(beat_id);
		System.out.println(result);
		return "/comment/beat";
	}
}
