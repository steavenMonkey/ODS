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
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@showmecoo.com)
 */

public class TimeClientHandle implements Runnable{
	
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean stop;
	
	/**
	 * 
	 */
	public TimeClientHandle(String host, int port) {
		this.host = host == null ? "127.0.0.1" : host;
		this.port = port;
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		//do connect
		try {
			doConnect();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		//deal data
		while(!stop){
			try {
				selector.select(1000);
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				SelectionKey key = null;
				while(it.hasNext()){
					key = it.next();
					it.remove();
					//handleInput data
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
	}
	
	private void handleInput(SelectionKey key) throws IOException{
		if(key.isValid()){
			SocketChannel sc = (SocketChannel) key.channel();
			//判断是否连接成功
			if(key.isConnectable()){
				if(sc.finishConnect()){
					sc.register(selector, SelectionKey.OP_READ);
					String message = "query time order";
					doWrite(sc, message);
				}else{
					// connect failed
					System.exit(1);
				}
			}
			if(key.isReadable()){
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if(readBytes > 0){
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("Receive message from time server: " + body);
					this.stop = true;
				}else if(readBytes < 0){
					//对端链路关闭
					key.cancel();
					sc.close();
				}else{
					//完成读取，无需做处理
				}
			}
			
		}
	}
	private void doConnect() throws IOException{
		if(socketChannel.connect(new InetSocketAddress(host, port))){
			System.out.println("success connect to " + host + ":" + port);
			//直连接成功，则注册到selector，发送请求消息，读应答
			socketChannel.register(selector, SelectionKey.OP_READ);
			//send request message
			String message = "query time order";
			doWrite(socketChannel, message);
		}else{
			System.out.println("connect to " + host + ":" + port);
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
		}
	}
	
	private void doWrite(SocketChannel sc, String message) throws IOException{
		byte[] writeBytes = message.getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(writeBytes.length);
		writeBuffer.put(writeBytes);
		writeBuffer.flip();
		sc.write(writeBuffer);
		if(!writeBuffer.hasRemaining()){
			System.out.println("Send order 2 time server success!");
		}
		
	}
	
	public static void main(String[] args) {
		byte[] bt = new byte[]{66, 65, 68, 32, 79, 82, 68, 69, 82};
		System.out.println(new String(bt));
	}

}

/*
 * 修改历史
 * $Log$ 
 */