package com.manyouyou.ordersystem.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.manyouyou.ordersystem.commons.SQLConstant;
import com.manyouyou.ordersystem.dao.IUserManagerDao;
import com.manyouyou.ordersystem.model.UserInfoModel;

public class UserManagerImpl implements IUserManagerDao {

	private SessionFactory sessionFacotry;
	
	public UserManagerImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFacotry = sessionFactory;
	}
	
	@Override
	public boolean addUser(UserInfoModel user) throws Exception {
		boolean flag = false;
		System.out.println("add user " + user);
		// 插入数据库
		// 纪录新增用户日志
		if(null == user){
			return flag;
		}
		Session session = null;
		try {
			session = sessionFacotry.getCurrentSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			//纪录新增用户日志
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();//技术异常，纪录日志，同时把异常抛到前台
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		return flag;
	}

	@Override
	public UserInfoModel findUserById(int userId) throws Exception {
		//纪录查询日志
		//查询数据库
		UserInfoModel user = null;
		Session session = sessionFacotry.getCurrentSession();
		session.beginTransaction();
		user = session.load(UserInfoModel.class, userId);
		session.getTransaction().commit();
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

	@SuppressWarnings("unchecked")
	@Override
	public UserInfoModel findUserByName(String userName) throws Exception {
		//纪录查询日志
		//查询数据库
		UserInfoModel user = null;
		Session session = sessionFacotry.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(SQLConstant.HQL_QUERY_USER_BY_NAME);
		query.setString(0, userName);
		List<UserInfoModel> list =  query.list();
		if(null != list && list.size() > 0){
			user = list.get(0);
		}
		session.getTransaction().commit();
		return user;
	}

}
