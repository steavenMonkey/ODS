package com.manyouyou.ordersystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manyouyou.ordersystem.commons.RequestConstant;
import com.manyouyou.ordersystem.commons.ResponseConstant;
import com.manyouyou.ordersystem.model.OrderModel;
import com.manyouyou.ordersystem.model.UserInfoModel;

@Controller
public class OrderController {
	
	@RequestMapping(value=RequestConstant.URI_ORDER_MYORDER)
	public String myOrder(ModelMap map){
		System.out.println("myOrder........");
		List<OrderModel> myOrderList = new ArrayList<OrderModel>();
		UserInfoModel user = (UserInfoModel) map.get(RequestConstant.MODELMAP_ATTR_USER);
		System.out.println(user);
		
		map.addAttribute("myOrderList", myOrderList);
		
		return ResponseConstant.RSP_PAGE_ORDER_MYORDER;
	}
}
