package com.manyouyou.ordersystem.dao;

import com.manyouyou.ordersystem.model.UserInfoModel;

public class UserManagerImpl implements IUserManager {


	@Override
	public boolean addUser(UserInfoModel user) throws Exception {
		boolean flag = false;
		System.out.println("add user " + user);
		// 插入数据库
		// 纪录新增用户日志
		return flag;
	}

	@Override
	public UserInfoModel findUserById(int userId) throws Exception {
		//纪录查询日志
		//查询数据库
		UserInfoModel user = new UserInfoModel();
		
		return user;
	}

	@Override
	public boolean updateUser(UserInfoModel newUser) throws Exception {
		// 纪录更新用户信息日志
		UserInfoModel oldUser = findUserById(newUser.getUserId());
		boolean flag = false;
		if (null != oldUser) {
			oldUser.setName(newUser.getName());
			oldUser.setPassword(newUser.getPassword());
			oldUser.setPhoneNum(newUser.getPhoneNum());
			// 插入数据库
		}
		return flag;
	}

	@Override
	public UserInfoModel findUserByName(String userName) throws Exception {
		//纪录查询日志
		//查询数据库
		UserInfoModel user = new UserInfoModel();
		
		return user;
	}

}
