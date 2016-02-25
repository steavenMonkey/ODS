package com.manyouyou.ordersystem.web.hello;

import org.springframework.beans.factory.annotation.Autowired;

public class Boss {
	
	@Autowired
	private Car car;
	
	public void out(){
		car.dirve();
	}
}
