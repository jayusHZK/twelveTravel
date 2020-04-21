package com.travel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.dao.RoleDao;
import com.travel.po.Role;
import com.travel.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	private RoleDao roleDao;//填充角色的dao
	
	/***
	 * 获取角色的集合
	 */
	@Override
	public List<Role> getRoleList() {
		return roleDao.getRoleList();
	}

}
