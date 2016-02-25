package com.manyouyou.ordersystem.dao;

import java.util.List;

import com.manyouyou.ordersystem.model.OrderModel;
import com.manyouyou.ordersystem.model.UserInfoModel;

public interface IOrderManagerDao extends IDao{
	
	public List<OrderModel> findOrderListByUserId(String userId);
	
	public OrderModel findOrderByUser(UserInfoModel user);
	
	public OrderModel findOrderByOrderId(String orderId);
	
	public boolean addOrder(OrderModel order);
	
	public boolean deleteOrder(OrderModel order);
	
	public boolean updateOrder(OrderModel order);
}
