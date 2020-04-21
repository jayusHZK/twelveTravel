package com.travel.dao;


import org.apache.ibatis.annotations.Param;

import com.travel.po.User;

public interface ChangeUserDao {
	//用户登录
	User login(@Param("user_name") String user_name, @Param("password") String password);
	//用户注册
	int register(User user);
	//根据用户id获取用户信息
	User getUserById(Integer user_id); 
	//获取所有用户的登录名
	int getUserLoginName(@Param("user_name") String user_name);
}
