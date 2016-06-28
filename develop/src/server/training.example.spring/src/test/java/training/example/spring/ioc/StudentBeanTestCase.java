package training.example.spring.ioc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan("training.example.spring.ioc")
public class StudentBeanTestCase {
	
	StudentBean stuent;
	StudentWiredBean studentWiredBean;
	
	private AnnotationConfigApplicationContext ctx;
	
	
	@Before
	public void init(){
		//spring ApplicationContext的两种初始化方式，如果是ClassPathXmlApplicationContext，并且是
		//maven项目，则需把配置文件放在src/main/resources下
//		ctx = new FileSystemXmlApplicationContext("src/bean.xml");
//		ctx = new ClassPathXmlApplicationContext("application.xml");
		ctx = new AnnotationConfigApplicationContext();
		ctx.register(BeanConfig.class);
		ctx.refresh();
//		stuent = ctx.getBean(StudentBean.class);
		studentWiredBean = ctx.getBean(StudentWiredBean.class);
	}
	
	@Test
	public void testGetName(){
//		stuent = (StudentBean) ctx.getBean("studentBean");
		
		System.out.println(stuent);
		studentWiredBean.test();
	}
}
