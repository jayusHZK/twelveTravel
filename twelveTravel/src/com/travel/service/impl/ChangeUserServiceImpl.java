package com.travel.service.impl;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.dao.ChangeUserDao;
import com.travel.po.Result;
import com.travel.po.User;
import com.travel.service.ChangeUserService;

@Service
public class ChangeUserServiceImpl implements ChangeUserService{
	@Autowired
	private ChangeUserDao changeUserDao;

	@Override
	/***
	 * 用户登录
	 * @param user 获取登陆用户的账号密码
	 * @return
	 */
	public Result login(User user,HttpSession session) {
		Result rs=new Result();
		User user1=new User();
		user1=changeUserDao.login(user.getUser_name(),user.getPassword());
		if(user1!=null){
			rs.setCode(200);
			rs.setMsg(user1);
			session.setAttribute("user", user1);
		}else{
			rs.setCode(400);
		}
		
		return rs;
	}
	/***
	 * 用户注册
	 * @param user
	 * @return
	 */
	@Override
	public int register(User user) {
		
		return changeUserDao.register(user);
	}
	/***
	 * 根据用户id获取用户信息
	 * @param user_id 获取用户id
	 * @return
	 */
	@Override
	public User getUserById(Integer user_id) {
		
		return changeUserDao.getUserById(user_id);
	}
	/***
	 * 获取所有用户的登录名
	 * 
	 * @return
	 */

	@Override
	public Result getUserLoginName(@Param("user_name") String user_name) {
		Result rs=new Result();
		rs.setCode(changeUserDao.getUserLoginName(user_name));
		return rs;
	}
}
