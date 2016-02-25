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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class SocketPacket {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;
	
	/**
	 * 
	 */
	public SocketPacket(Socket socket) {
		super();
		this.socket = socket;
	} 
	
	
	public Object read() throws IOException, ClassNotFoundException{
		if(null == ois){
			ois = new ObjectInputStream(socket.getInputStream());
		}
		Object ret = ois.readObject();
		
		return ret;
		
	}
	
	
	public void write(Object obj) throws IOException{
		if(null == oos){
			oos = new ObjectOutputStream(socket.getOutputStream());
		}
		oos.writeObject(obj);
		oos.flush();
	}
}

/*
 * 修改历史
 * $Log$ 
 */