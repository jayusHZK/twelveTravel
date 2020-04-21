package com.travel.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.dao.UserDao;
import com.travel.po.Page;
import com.travel.po.Result;
import com.travel.po.Role;
import com.travel.po.User;
import com.travel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;// 填充用户的dao

	/***
	 * 获取用户id
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public User getUserById(Integer user_id) {
		return userDao.getUserById(user_id);
	}

	/***
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public Result addUser(User user,Integer role_id) {
		Result r=new Result();
		Role role=new Role();
		role.setRole_id(role_id);
		user.setRole(role);
		r.setCode(userDao.addUser(user));
		return r;
	}

	/***
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public Result editUser(User user,Integer role_id) {
		Result r=new Result();
		Role role=new Role();
		role.setRole_id(role_id);
		user.setRole(role);
		//如果用户id不等于0并且大于0的话
		if(user.getUser_id()!=0&&user.getUser_id()>0){
			r.setCode(userDao.editUser(user));//执行修改用户
		}		
		return r;
	}
	
	/***
	 * 查询用户(判断用户是否已经被注册过)
	 */
	@Override
	public Result findUser(User user) {
		Result r=new Result();
		user.getUser_name();
		r.setMsg(userDao.findUser(user));
		return r;
	}

	/***
	 * 用户的分页
	 */
	@Override
	public Page getUserList(Integer index, String user_name, Integer role_id) {
		Page rp = new Page();
		// 根据条件来查询
		rp.setSize(5);// 一页显示多少条数据
		rp.setIndex(index); // 当前是哪一页
		//
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (index - 1) * rp.getSize());
		map.put("end", rp.getSize());
		map.put("user_name", user_name);
		map.put("role_id", role_id);

		// 获取总条数
		rp.setCount(userDao.getUserListCount(map).intValue());
		// 获取总页数
		rp.setPageCount((int) Math.ceil((double) rp.getCount() / rp.getSize()));
		// 获取每一页的条数
		rp.setObj(userDao.getUserListByIndex(map));
		return rp;
	}

	/***
	 * 用户登录
	 */
	//@Override
	//public User login(User user) {
	//	return userDao.login(user.getUser_name(), user.getPassword());
	//}

	/***
	 * 删除用户
	 */
	@Override
	public int delUser(Integer user_id) {
		int result=userDao.delUser(user_id);
		return result;
	}

}
