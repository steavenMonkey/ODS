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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class AsyncTimeSeverHandler implements Runnable{
	
	private int port;
	CountDownLatch latch;
	AsynchronousServerSocketChannel asssc;
	
	/**
	 * 
	 */
	public AsyncTimeSeverHandler(int port) {
		this.port = port;
		try {
			asssc = AsynchronousServerSocketChannel.open();
			asssc.bind(new InetSocketAddress(port));
			System.out.println("The async time server is start in port: " + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		latch = new CountDownLatch(1);
		//doaccept;
		doAccept();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private void doAccept(){
//		asssc.accept(this, new AcceptCompletionHandler());
		asssc.accept(this, new AcceptCompletionHandler());
	}

}

/*
 * 修改历史
 * $Log$ 
 */