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

import java.sql.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class TimeServerHandler extends ChannelHandlerAdapter{

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelHandlerAdapter#channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object)
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] bytes = new byte[buf.readableBytes()];
		buf.readBytes(bytes);
		String body = new String(bytes, "UTF-8");
		System.out.println("Netty time server receive order: " + body);
		String res = body.equalsIgnoreCase("QUERY TIME ORDER") ? new Date(System.currentTimeMillis()).toString() : "DAD ORDER";
		ByteBuf resBuf = Unpooled.copiedBuffer(res.getBytes());
		ctx.write(resBuf);
		
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelHandlerAdapter#channelReadComplete(io.netty.channel.ChannelHandlerContext)
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	/* (non-Javadoc)
	 * @see io.netty.channel.ChannelHandlerAdapter#exceptionCaught(io.netty.channel.ChannelHandlerContext, java.lang.Throwable)
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
}

/*
 * 修改历史
 * $Log$ 
 */