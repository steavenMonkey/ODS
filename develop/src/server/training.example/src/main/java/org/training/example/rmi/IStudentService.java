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
 * Created on 2015年5月10日
 *******************************************************************************/


package org.training.example.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * TODO 此处填写 class 信息
 *
 * @author weixin (mailto:weixin@primeton.com)
 */

public interface IStudentService extends Remote{
	
	public List<Student> getStudentList() throws RemoteException;

}

/*
 * 修改历史
 * $Log$ 
 */