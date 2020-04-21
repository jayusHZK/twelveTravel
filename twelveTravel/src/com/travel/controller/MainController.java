package com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.travel.service.MainService;

@Controller
@RequestMapping("/main")
public class MainController {
	//从spring容器中获取类
	@Autowired
	private MainService mainService;
	/***
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toLogin(){
		return "/frist/frist";
	}
	/***
	 * 后台头部页面的显示
	 * @return
	 */
	@RequestMapping("/totop")
	public String toTop(){
		return "/main/top";
	}
	/***
	 * 后台左方页面的显示
	 * @param m
	 * @return
	 */
	@RequestMapping("/toleft")
	public String toLeft(Model m){
		m.addAttribute("leftpower", mainService.getPower());
		return "/main/left";
	}
	/***
	 * 后台右方页面的显示
	 * @param m
	 * @return
	 */
	@RequestMapping("/toright")
	public String toRight(){
		return "/main/right";
	}
	/***
	 * 后台主页面的显示
	 * @return
	 */
	@RequestMapping("/tomain")
	public String toMain(){
		return "/main/main";
	}
	
}
