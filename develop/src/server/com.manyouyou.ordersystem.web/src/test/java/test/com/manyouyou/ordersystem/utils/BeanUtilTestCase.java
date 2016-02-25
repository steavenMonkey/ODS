package test.com.manyouyou.ordersystem.utils;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.manyouyou.ordersystem.utils.SpringUtil;
import com.manyouyou.ordersystem.web.hello.Boss;

public class BeanUtilTestCase {
	
	
	@Test
	public void getApplicationContextTest(){
		ApplicationContext ctx = SpringUtil.getApplicationContext();
		System.out.println(ctx);
		Boss b = (Boss) ctx.getBean("boss");
		b.out();
		
	}

}
