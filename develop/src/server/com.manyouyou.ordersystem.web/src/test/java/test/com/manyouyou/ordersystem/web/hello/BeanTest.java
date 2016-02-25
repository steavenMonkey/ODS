package test.com.manyouyou.ordersystem.web.hello;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manyouyou.ordersystem.web.hello.Boss;
import com.manyouyou.ordersystem.web.hello.HelloBean;

public class BeanTest {
	private ApplicationContext context;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
	public void sayHelloTest(){
		HelloBean  hb =  (HelloBean) context.getBean("helloBean");
		hb.sayHello();
		
	}
	
	
	
	@Test
	public void outTest(){
		Boss boss = (Boss) context.getBean("boss");
		boss.out();
	}
}
