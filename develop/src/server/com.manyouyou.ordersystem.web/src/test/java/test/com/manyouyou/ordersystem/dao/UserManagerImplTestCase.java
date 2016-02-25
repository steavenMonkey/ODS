package test.com.manyouyou.ordersystem.dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.manyouyou.ordersystem.commons.BeanConstant;
import com.manyouyou.ordersystem.dao.impl.UserManagerImpl;
import com.manyouyou.ordersystem.model.UserInfoModel;
import com.manyouyou.ordersystem.utils.SpringUtil;

public class UserManagerImplTestCase {
	
	private UserManagerImpl manager;
	
	@Before
	public void before(){
		manager = (UserManagerImpl) SpringUtil.getBean(BeanConstant.BEAN_USERMANAGER_ID);
	}

	@Test
	public void testUserManagerImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		UserInfoModel user = new UserInfoModel();
		try {
			user.setName("test");
			user.setPassword("123");
			user.setPhoneNum("1111");
			manager.addUser(user );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindUserById() {
		int id = 1;
		try {
			UserInfoModel user = manager.findUserById(id);
			Assert.assertNotNull(user);
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByName() {
		String userName = "aa";
		UserInfoModel user;
		try {
			user = manager.findUserByName(userName);
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
