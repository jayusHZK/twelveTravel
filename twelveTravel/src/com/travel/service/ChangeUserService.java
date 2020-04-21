package com.travel.service;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.travel.po.Result;
import com.travel.po.User;

public interface ChangeUserService {
	//用户登录
	Result login(User user,HttpSession session);
	//用户注册
	int register(User user);
	//根据用户id获取用户信息
	User getUserById(Integer user_id);
	//获取所有用户的登录名
	Result getUserLoginName(@Param("user_name") String user_name);
}
