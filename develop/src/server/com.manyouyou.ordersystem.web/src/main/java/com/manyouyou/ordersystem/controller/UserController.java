package com.manyouyou.ordersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manyouyou.ordersystem.commons.RequestConstant;
import com.manyouyou.ordersystem.commons.ResponseConstant;
import com.manyouyou.ordersystem.dao.DaoFactory;
import com.manyouyou.ordersystem.dao.IUserManager;
import com.manyouyou.ordersystem.dao.UserManagerImpl;
import com.manyouyou.ordersystem.model.UserInfoModel;

@Controller
public class UserController {
	
	@RequestMapping(value=RequestConstant.URI_USER_LOGIN)
	public String login(UserInfoModel user,ModelMap map){
		System.out.println("...... login ......");
		System.out.println(user);
		System.out.println("纪录登录日志");
		
		/*
		 * 登录成功跳转到我的订单
		 */
		UserManagerImpl userManager =  (UserManagerImpl) DaoFactory.getDaoImpl(IUserManager.class);
		try {
			UserInfoModel dbUser = userManager.findUserByName(user.getName());
			if(null == dbUser){
				//跳转到登录异常页面
				map.addAttribute(ResponseConstant.RSP_ATTR_LOGIN_ERROR, "user does not exist,please regist first");
				return ResponseConstant.RSP_PAGE_LOGIN;
			}
			
			String inPassword = user.getPassword();
			String password = dbUser.getPassword();
			
		} catch (Exception e) {
			//纪录日志，返回错误信息，跳转到登录异常页面
			e.printStackTrace();
		}
		
		return RequestConstant.URI_FORWARD + RequestConstant.URI_ORDER_MYORDER;
	}
	
	
	@RequestMapping(value=RequestConstant.URI_USER_REGIST)
	public String regist(UserInfoModel user,ModelMap map){
		
		System.out.println("regist user....");
		System.out.println(user);
		map.addAttribute("user", user);
		/*
		 * 注册成功转发到我的订单
		 * forward:order/myOrder.do
		 * 
		 */
		return RequestConstant.URI_FORWARD + RequestConstant.URI_ORDER_MYORDER;
	}
}
