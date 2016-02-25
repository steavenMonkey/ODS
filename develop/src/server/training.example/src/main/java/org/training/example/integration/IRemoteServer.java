/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2012 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2015年5月13日
 *******************************************************************************/


package org.training.example.integration;

/**
 * 远程服务调用的Server接口
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public interface IRemoteServer {
	/**
	 * 服务绑定
	 * @param serviceName
	 * @param service
	 */
	public void bind(String serviceName,Object service);
	
	/**
	 * 服务取消绑定
	 * @param <T>
	 * @param <K>
	 * @param serviceName
	 */
	public void unbind(String serviceName);
}

/*
 * 修改历史
 * $Log$ 
 */