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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class MultiplexerTimeServer implements Runnable{
	
	private Selector selector;
	private ServerSocketChannel servChannel;
	private boolean stop;
	
	/**
	 * 
	 */
	public MultiplexerTimeServer(int port) {
		try {
			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress(port), 1024);
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port " + port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	public void stop(){
		this.stop = true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		while(!stop){
			try {
				selector.select(1000);//间隔1s轮询一次
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iter = selectedKeys.iterator();
				SelectionKey key = null;
				while(iter.hasNext()){
					key = iter.next();
					iter.remove();
					//handleKey
					try {
						handleInput(key);
					} catch (IOException e) {
						
						if(key != null){
							key.cancel();
							if(key.channel() != null){
								key.channel().close();
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(selector != null){
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleInput(SelectionKey key) throws IOException{
		if(key.isValid()){
			//处理新接入的连接
			if(key.isAcceptable()){
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				//add new connection to selector
				sc.register(selector, SelectionKey.OP_READ);
			}
			
			if(key.isReadable()){
				//read data
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if(readBytes>0){
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order: "+ body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
					//dowrite
					doWrite(sc, currentTime);
					
				}else if(readBytes < 0){
					//关闭端链路
					key.cancel();
					sc.close();
				}else{
					//读到0字节，忽略
				}
				
			}
			
		}
		
	}
	
	
	private void doWrite(SocketChannel sc, String message) throws IOException{
		if(message != null && message.trim().length() > 0){
			byte[] writeBytes = message.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(writeBytes.length);
			writeBuffer.put(writeBytes);
			writeBuffer.flip();
			sc.write(writeBuffer);
		}
	}
	
}

/*
 * 修改历史
 * $Log$ 
 */