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
 * Created on 2017年2月10日
 *******************************************************************************/


package example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class TimeClientHandler extends ChannelHandlerAdapter{
	
	private ByteBuf firstMessage;
	/**
	 * 
	 */
	public TimeClientHandler() {
		byte[] req = "query time order".getBytes();
		this.firstMessage = Unpooled.buffer(req.length);
		firstMessage.writeBytes(req);
		
	}
	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelHandlerAdapter#exceptionCaught(io.netty.channel.ChannelHandlerContext, java.lang.Throwable)
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
		
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelHandlerAdapter#channelActive(io.netty.channel.ChannelHandlerContext)
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(firstMessage);
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelHandlerAdapter#channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object)
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf res = (ByteBuf) msg;
		byte[] bytes = new byte[res.readableBytes()];
		res.readBytes(bytes);
		String body = new String(bytes,"UTF-8");
		System.out.println("Now is: " + body);
		
	}
	

}

/*
 * 修改历史
 * $Log$ 
 */