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
 * 远程服务调用的client端接口
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public interface IRemoteClient {
	
	public <T> T lookup(String serviceName);
}

/*
 * 修改历史
 * $Log$ 
 */