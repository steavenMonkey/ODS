package com.manyouyou.ordersystem.dao;

import com.manyouyou.ordersystem.model.UserInfoModel;

public interface IUserManagerDao extends IDao{
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean addUser(UserInfoModel user) throws Exception;
	
	/**
	 * 根据userId查找user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserInfoModel findUserById(int userId) throws Exception;
	
	/**
	 * 更新user
	 * @param newUser
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(UserInfoModel newUser) throws Exception;
	
	/**
	 * 根据用户名查询user
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public UserInfoModel findUserByName(String userName) throws Exception;
}
