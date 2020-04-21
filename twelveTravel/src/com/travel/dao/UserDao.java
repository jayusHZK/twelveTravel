package com.travel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.travel.po.User;

public interface UserDao {
	
	//User login(@Param("user_name") String user_name,@Param("password") String passowrd);
	
	int findUser(User user);
	
	//添加用户
	int addUser(User user);
	
	//修改用户
	int editUser(User user);
	
	//获取用户id
	User getUserById(Integer user_id);
	
	// 获取用户分页的总条数
	Long getUserListCount(Map map);
	
	// 获取每一页的条数
	List<User> getUserListByIndex(Map param);
	
	//删除用户
	int delUser(Integer user_id);
}
