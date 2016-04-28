package example.spring.boot.demo.yaml;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ComponentScan("example.spring.boot.demo.yaml")
@ActiveProfiles("unit-test")
@RunWith(SpringJUnit4ClassRunner.class)
//ConfigFileApplicationContextInitializer是一个ApplicationContextInitializer，
//可以用来测试加载Spring Boot的application.properties文件。
//当不需要使用@SpringApplicationConfiguration提供的全部特性时，你可以使用它。
@ContextConfiguration(classes=TestDogeConfig.class, initializers = ConfigFileApplicationContextInitializer.class)
public class DogeSettingsTestCase2 {
	
	@Autowired
	private DogeSettings dogeSettings;
	
	@Test
	public void testGetWow(){
		Assert.assertEquals("use ContextConfiguration instead of SpringApplicationConfiguration", 4, dogeSettings.getWow());
	}
}
