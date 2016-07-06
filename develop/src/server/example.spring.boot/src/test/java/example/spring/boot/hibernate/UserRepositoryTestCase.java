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

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import example.spring.boot.restful.demo.resteasy.User;

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(HibernateApplication.class)
@Transactional
public class UserRepositoryTestCase {
	
	@Autowired
	private UserRepository userRepository;
	/*
	 * CREATE TABLE `showmecoo`.`user` (
  `userid` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `rolename` VARCHAR(45) NULL,
  `createdate` DATETIME NOT NULL,
  `modifydate` DATETIME NOT NULL,
  `lastlogindate` DATETIME NOT NULL,
  `openid` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`));
	 */
	@Test
	@Rollback(false)//if true, after method all the operation will rollback even though without any exception
	public void testCreate(){
		UserEntity user = new UserEntity();
//		user.setUserId("1");
		user.setUserName("mac");
		user.setPassword("1234");
		user.setPhone("123456789");
		user.setEmail("ss@aa.com");
		user.setRolename("admin");
		user.setCreateDate(new Date());
		user.setModifyDate(new Date());
		user.setLastLoginDate(new Date());
		user.setOpenId("1234");
		try {
			
			userRepository.create(user);
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	@Rollback(false)
	public void tesGetAll(){
		List<UserEntity> userList = userRepository.getAll();
		for(UserEntity entity:userList){
			System.out.println(entity);
		}
	}
	
	
	@Test
//	@Rollback(false)
	public void testFindUserByName(){
		UserEntity user = userRepository.findUserByName("mac");
		System.out.println(user);
	}
	
	@Test
	@Rollback(false)
	public void testUpdate(){
		UserEntity ouser = userRepository.findUserByName("mac");
		ouser.setPassword("1234");
		userRepository.update(ouser);
		System.out.println(userRepository.findUserByName("mac").getPassword());
	}
	
	
	@Test
	@Rollback(false)
	public void testDelete(){
		UserEntity user = userRepository.findUserByName("mac");
		userRepository.delete(user);
	}
	
	
}

/*
 * 修改历史
 * $Log$ 
 */