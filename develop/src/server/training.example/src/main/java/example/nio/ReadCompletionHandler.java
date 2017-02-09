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
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer>{
	
	private AsynchronousSocketChannel ssc;
	
	/**
	 * 
	 */
	public ReadCompletionHandler(AsynchronousSocketChannel ssc) {
			this.ssc = ssc;
	}

	/* (non-Javadoc)
	 * @see java.nio.channels.CompletionHandler#completed(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		attachment.flip();
		byte[] bytes = new byte[attachment.remaining()];
		attachment.get(bytes);
		try {
			String req = new String(bytes, "utf-8");
			System.out.println("The time server receive order: " + req);
			String res = req.equals("QUERY TIME ORDER") ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
			doWrite(res);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see java.nio.channels.CompletionHandler#failed(java.lang.Throwable, java.lang.Object)
	 */
	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {
		if(null != ssc){
			try {
				ssc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void doWrite(String message){
		if(null != message && message.trim().length() > 0){
			byte[] mbyte = message.getBytes();
			ByteBuffer buffer = ByteBuffer.allocate(mbyte.length);
			buffer.put(mbyte);
			buffer.flip();
			ssc.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {

				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					if(attachment.hasRemaining()){
						ssc.write(attachment, attachment, this);
					}
					
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					exc.printStackTrace();
					try {
						ssc.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		}
	}

}

/*
 * 修改历史
 * $Log$ 
 */