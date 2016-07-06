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
 * Created on 2016年7月6日
 *******************************************************************************/


package example.spring.boot.hibernate;

import org.springframework.data.repository.CrudRepository;

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */

public interface UserDao extends CrudRepository<UserEntity, String>{
	
	
}

/*
 * 修改历史
 * $Log$ 
 */