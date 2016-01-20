package com.manyouyou.ordersystem.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DaoFactory {
	
	@SuppressWarnings("rawtypes")
	private static Map<Class,IDao> daoImplsMap = new ConcurrentHashMap<Class, IDao>();
	
	private void regist(){
		daoImplsMap.clear();
		daoImplsMap.put(UserManagerImpl.class, new UserManagerImpl());
	}
	
	
	@SuppressWarnings("rawtypes")
	public static IDao getDaoImpl(Class clazz){
		return daoImplsMap.get(clazz);
	}
}
