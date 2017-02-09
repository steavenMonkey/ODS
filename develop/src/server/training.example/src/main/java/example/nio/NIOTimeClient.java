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
 * Created on 2017年2月8日
 *******************************************************************************/


package example.nio;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class NIOTimeClient {
	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 9090;
		TimeClientHandle tch = new TimeClientHandle(host, port);
		new Thread(tch, "NIO-TimeClientHandler-001").start();
	}
}

/*
 * 修改历史
 * $Log$ 
 */