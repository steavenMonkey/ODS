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

public class NIOTimeServer {
	public static void main(String[] args) {
		MultiplexerTimeServer mts = new MultiplexerTimeServer(9090);
		new Thread(mts, "NIO-MultiplexerTimeSever-001").start();
	}
}

/*
 * 修改历史
 * $Log$ 
 */