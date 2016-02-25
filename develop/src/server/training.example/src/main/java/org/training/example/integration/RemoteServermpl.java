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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;


/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class RemoteServermpl implements IRemoteServer {
	
	private ConcurrentHashMap<String, Object> serviceMap = new ConcurrentHashMap<String, Object>();
	private TCPSocketServer tcpServer;
	
	/**
	 * @throws IOException 
	 * 
	 */
	public RemoteServermpl(String ip,int port) throws IOException {
		tcpServer = new TCPSocketServer(ip, port);
		tcpServer.start();
	}
	
	
	@Override
	public void bind(String serviceName, Object service) {
		Object s = serviceMap.get(serviceName);
		if( null == s){
			serviceMap.put(serviceName, service);
		}
	}

	@Override
	public void unbind(String serviceName) {
		serviceMap.remove(serviceName);
	}
	
	public Object invoke(String key){
		Object ret = serviceMap.get(key);
		if(null == ret){
			throw new IllegalArgumentException();
		}
		return ret;
	}
	
	 class TCPSocketServer{

		
		private ServerSocket serverSocket;
		private boolean stop = false;
		
		public TCPSocketServer(String ip,int port) throws IOException{
			super();
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(ip, port));
			System.out.println("start server " + serverSocket.getLocalSocketAddress());
		}
		
		public void start(){
			new Thread("TCPSocketServer-Accept"){
				/* (non-Javadoc)
				 * @see java.lang.Thread#run()
				 */
				@Override
				public void run() {
					_run();
				}
			};
		}
		
		private void _run(){
			while(!stop){
				try {
					Socket socket = serverSocket.accept();
					SocketPacket packet = new SocketPacket(socket);
					Object ret = RemoteServermpl.this.invoke((String)packet.read());
					packet.write(ret);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		
		public void stop(){
			this.stop = true;
		}

	}
}

/*
 * 修改历史 $Log$
 */