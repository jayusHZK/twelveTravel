package com.travel.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travel.po.Result;
import com.travel.po.User;
import com.travel.service.ChangeUserService;

@Controller
@RequestMapping("/changeuser")
/***
 * 前端用户模块的controller
 * @author cxw
 *
 */
public class ChangeUserController {
	@Autowired
	// 引入changeUserService
	private ChangeUserService changeUserService;

	@RequestMapping("/login")
	@ResponseBody
	/***
	 *用户登录
	 * @param user 获取用户登录的账号密码
	 * @param session 用作将用户信息存入session
	 * @return
	 */
	public Result login(User user, HttpSession session) {
		
		return changeUserService.login(user,session);
	}

	/***
	 * 用户退出登录
	 * 
	 * @param session 用作将用户信息存入session
	 * @return
	 */
	@RequestMapping("/loginout")
	public String loginout(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			session.removeAttribute("user");
		}
		return "redirect:/main/tologin";
	}
	/***
	 * 注册
	 * @param m 用model将用户信息存起来
	 * @param user_id 用户id
	 * @return
	 */
	@RequestMapping("/toregister")
	public String toRegister(Model m, Integer user_id) {

		// 判断user_id是否存在 存在呢就查询对应用户
		if (user_id != null && user_id != 0) {
			User user = changeUserService.getUserById(user_id);
			m.addAttribute("userInfo", user);
		}
		return "/frist/register";
	}

	@RequestMapping("/register")
	/***
	 *用户注册
	 * @param user 获取用户登录的账号密码
	 * @param session 用作将用户信息存入session
	 * @return
	 */
	public String register(HttpSession session, User user) {
		// 注册用户
		int reuslt = changeUserService.register(user);
		if (reuslt > 0) {// 注册成功 重定向到首页
			return "redirect:/main/tologin";
		} else {// 否则 返回到注册页面
			return "redirect:/changeuser/toregister";
		}
	}
	/***
	 * 获取所有的用户名
	 * @param user_name 用户名
	 * @return
	 */
	@RequestMapping("/getUserLoginName")
	@ResponseBody	
	public Result getUserLoginName(@Param("user_name") String user_name) {
		
		return changeUserService.getUserLoginName(user_name);
	}


}
