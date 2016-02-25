package com.manyouyou.ordersystem.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manyouyou.ordersystem.commons.BeanConstant;

public class SpringUtil {
	
	private static ApplicationContext ctx = null;
	
	static{
		ctx = new ClassPathXmlApplicationContext(BeanConstant.BEAN_CONFIG_FILE_NAME);
	}
	
	
	public static ApplicationContext getApplicationContext(){
		return ctx;
	}
	
	public static Session getHibernateSession(){
		SessionFactory sf = getHibernateSessionFactory();
		Session session = sf.getCurrentSession();
		return session;
	}
	
	public static SessionFactory getHibernateSessionFactory(){
		SessionFactory sessionFacotry = (SessionFactory) SpringUtil.getApplicationContext().getBean(BeanConstant.BEAN_HIBERNATE_SESSIONFACTORY);
		return sessionFacotry;
	}
	
	public static Object getBean(String name){
		return getApplicationContext().getBean(name);
	}
}
