package com.manyouyou.ordersystem.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.manyouyou.ordersystem.dao.IOrderManagerDao;
import com.manyouyou.ordersystem.model.OrderModel;
import com.manyouyou.ordersystem.model.UserInfoModel;

public class OrderManagerImpl implements IOrderManagerDao{
	
	private SessionFactory sessionFactory;
	
	public OrderManagerImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<OrderModel> findOrderListByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderModel findOrderByUser(UserInfoModel user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderModel findOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addOrder(OrderModel order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(OrderModel order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrder(OrderModel order) {
		// TODO Auto-generated method stub
		return false;
	}

}
