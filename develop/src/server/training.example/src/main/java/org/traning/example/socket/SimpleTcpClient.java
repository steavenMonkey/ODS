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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public class SimpleTcpClient {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 18081);
//			BufferedInputStream bs = new BufferedInputStream(System.in);
			BufferedOutputStream bo = new BufferedOutputStream(s.getOutputStream());
			bo.write("aaa".getBytes());
			bo.flush();
			int i;
			byte[] b = new byte[1024];
//			while((i=bs.read(b))!=-1){
//				bo.write(b);
//			}
			BufferedInputStream bfs = new BufferedInputStream(s.getInputStream());
			while((i=bfs.read(b))!=-1){
				System.out.println(b);
			}
			
			bo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
		
	}
}

/*
 * 修改历史
 * $Log$ 
 */