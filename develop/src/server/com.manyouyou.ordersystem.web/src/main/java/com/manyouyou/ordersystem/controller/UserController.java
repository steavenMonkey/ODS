package com.manyouyou.ordersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manyouyou.ordersystem.commons.BeanConstant;
import com.manyouyou.ordersystem.commons.RequestConstant;
import com.manyouyou.ordersystem.commons.ResponseConstant;
import com.manyouyou.ordersystem.dao.impl.UserManagerImpl;
import com.manyouyou.ordersystem.model.UserInfoModel;
import com.manyouyou.ordersystem.utils.SpringUtil;
import com.manyouyou.ordersystem.utils.StringUtil;

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
		UserManagerImpl userManager = (UserManagerImpl) SpringUtil.getBean(BeanConstant.BEAN_USERMANAGER_ID);
		try {
			UserInfoModel dbUser = userManager.findUserByName(user.getName());
			if(null == dbUser){
				//跳转到登录异常页面
				map.addAttribute(ResponseConstant.RSP_ATTR_LOGIN_ERROR, "用户不存在，请先注册");
				return ResponseConstant.RSP_PAGE_LOGIN;
			}
			
			String inPassword = user.getPassword();
			String password = dbUser.getPassword();//加密后数据
			if(null == inPassword || inPassword.trim().length() <=0){
				//跳转到登录异常页面
				map.addAttribute(ResponseConstant.RSP_ATTR_LOGIN_ERROR, "密码不能为空");
				return ResponseConstant.RSP_PAGE_LOGIN;
			}
			
			inPassword = StringUtil.encode(inPassword);
			if(!password.equals(inPassword)){
				//跳转到登录异常页面
				map.addAttribute(ResponseConstant.RSP_ATTR_LOGIN_ERROR, "密码错误，请重新输入");
				return ResponseConstant.RSP_PAGE_LOGIN;
			}
			map.addAttribute(RequestConstant.MODELMAP_ATTR_USER, dbUser);
		} catch (Exception e) {
			//纪录日志，返回错误信息，跳转到登录异常页面
			e.printStackTrace();
			return ResponseConstant.RSP_PAGE_LOGIN;
		}
		/*登录成功转发到我的订单*/
		return RequestConstant.URI_FORWARD + RequestConstant.URI_ORDER_MYORDER;
	}
	
	
	/**
	 * 用户注册action
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping(value=RequestConstant.URI_USER_REGIST)
	public String regist(UserInfoModel user,ModelMap map){
		
		System.out.println("regist user....");
		UserManagerImpl userManager = (UserManagerImpl) SpringUtil.getBean(BeanConstant.BEAN_USERMANAGER_ID);
		
		String password = user.getPassword();
		String userName = user.getName();
		if(StringUtil.isEmpty(userName)
				|| StringUtil.isEmpty(password)){
			System.out.println("user name or password cannot be null or blank");
			map.addAttribute(ResponseConstant.RSP_ATTR_REGIST_ERROR, "用户名或密码不能为空");
			return ResponseConstant.RSP_PAGE_REGIST;
		}
		
		try {
			UserInfoModel dbUser = userManager.findUserByName(userName);
			if(null != dbUser){
				map.addAttribute(ResponseConstant.RSP_ATTR_REGIST_ERROR, "该用户名已被注册，请重新输入");
				return ResponseConstant.RSP_PAGE_REGIST;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		password = StringUtil.encode(password);
		user.setPassword(password);
		
		System.out.println(user);
		map.addAttribute("user", user);
		
		boolean registFlag = false;
		try {
			registFlag = userManager.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();//技术异常，纪录日志，提示注册失败，请重试
			map.addAttribute(ResponseConstant.RSP_ATTR_REGIST_ERROR, "注册失败，请重试");
			return ResponseConstant.RSP_PAGE_REGIST;
		}
		
		/*
		 * 注册成功转发到我的订单
		 * forward:order/myOrder.do
		 * 
		 */
		if(registFlag){
			return RequestConstant.URI_FORWARD + RequestConstant.URI_ORDER_MYORDER;
		}else{
			map.addAttribute(ResponseConstant.RSP_ATTR_REGIST_ERROR, "注册失败，请重试");
			return ResponseConstant.RSP_PAGE_REGIST;
		}
//		return RequestConstant.URI_FORWARD + RequestConstant.URI_ORDER_MYORDER;
	}
}
