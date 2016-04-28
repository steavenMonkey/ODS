package example.spring.boot.demo.yaml;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ComponentScan("example.spring.boot.demo.yaml")
@ActiveProfiles("unit-test")
//Spring Boot提供一个@SpringApplicationConfiguration注解用来替换标准的spring-test　
//@ContextConfiguration注解。如果使用@SpringApplicationConfiguration来设置你的测试中使用的ApplicationContext，
//它最终将通过SpringApplication创建，并且你将获取到Spring Boot的其他特性。
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={SuchApplication.class,TestDogeConfig.class})
public class DogeSetingsTestCase {
	
	@Autowired
	private DogeSettings dogesettings;
	
	@Autowired
	private DogeRepository dogeRepository;
	
	@Test
	public void testGetWow(){
		Assert.assertEquals("using unit-test profile ", "test-DogeRepository-Data", dogeRepository.getData());
		Assert.assertEquals("already use unit-test profile", 4, dogesettings.getWow());
	}
}
