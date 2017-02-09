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
 * Created on 2017年2月9日
 *******************************************************************************/


package example.nio;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class AIOTimeClient {
	public static void main(String[] args) {
		new Thread(new AsyncTimeClientHanlder("127.0.0.1", 9191), "AIO-aysncTimeClient-001").start();
	}
}

/*
 * 修改历史
 * $Log$ 
 */