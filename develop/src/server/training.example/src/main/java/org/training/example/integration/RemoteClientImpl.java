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
 * Created on 2015年5月17日
 *******************************************************************************/


package org.training.example.integration;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class RemoteClientImpl implements IRemoteClient{
	
	private TCPClient client;
	
	
	public RemoteClientImpl(String ip,int port) throws IOException {
		client = new TCPClient(ip, port);
	}

//	@SuppressWarnings("unchecked")
//	@Override
	public <T> T lookup(String serviceName) {
		T ret = null;
		try {
			 ret = (T) client.sendAndRecieve(serviceName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	class TCPClient{
		Socket socket;
		SocketPacket packet;
		
		public TCPClient(String ip,int port) throws IOException{
			super();
			socket = new Socket();
			socket.connect(new InetSocketAddress(ip, port));
			packet = new SocketPacket(socket);
		}
		
		public Object sendAndRecieve(String serviceName) throws IOException, ClassNotFoundException{
			packet.write(serviceName);
			Object ret = packet.read();
			return ret;
		}
	}
}

/*
 * 修改历史
 * $Log$ 
 */