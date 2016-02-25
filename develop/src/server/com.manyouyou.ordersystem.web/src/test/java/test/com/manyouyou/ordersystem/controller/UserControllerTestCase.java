package test.com.manyouyou.ordersystem.controller;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import com.manyouyou.ordersystem.controller.UserController;
import com.manyouyou.ordersystem.model.UserInfoModel;

public class UserControllerTestCase {
	
	private static UserController userController;
	
	@BeforeClass
	public static void beforeClass(){
		userController = new UserController();
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegist() {
		UserInfoModel user = new UserInfoModel();
		user.setName("test1");
		user.setPassword("000000");
		user.setPhoneNum("123");
		ModelMap map = new ModelMap();
		userController.regist(user, map);
	}

}
