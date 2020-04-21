package com.travel.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.travel.dao.PowerDao;
import com.travel.po.Power;
import com.travel.po.User;

public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private PowerDao powerDao;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// 获取访问的路劲
		String url = arg0.getRequestURI();
		//截取路径的controller和action
		String uri=url.substring(14);
		System.out.println(uri);
		//获取所有权限
		List<Power> pList=powerDao.getPowerList();
		List<String> list=new ArrayList<String>();
		//将所有权限塞入list
		for (Power item : pList) {
			list.add(item.getController()+"/"+item.getAction());
		}
		//比较路径和list的值 相同 则是权限 需要过滤
		for (String item1 : list) {
			if(uri.equals(item1)){
				User user=(User) arg0.getSession().getAttribute("user");
				if(user==null||user.getRole().getRole_id()!=1){
					arg1.sendRedirect(arg0.getContextPath() + "/main/tologin");
					return false;
				}
			}
		}
		return true;
	}
}
