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
 * Created on 2015年5月12日
 *******************************************************************************/


package org.traning.example.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class SimpleServerSocket {
	public static void main(String[] args) {
		try {
			ServerSocket sever = new ServerSocket(18081);
			System.out.println("server start in 18081");
			while(true){
				Socket s = sever.accept();
				System.out.println("get one connect");
				InetAddress ip = s.getInetAddress();
				InputStream in = s.getInputStream();
				byte[] b = new byte[1024];
				int i;
				while((i=in.read(b)) != -1){
					System.out.println(new String(b));
					OutputStream out = s.getOutputStream();
					out.write(ip.toString().getBytes());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

/*
 * 修改历史
 * $Log$ 
 */