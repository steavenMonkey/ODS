package example.spring.boot.demo.yaml;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ActiveProfiles("unit-test")
@ComponentScan("example.spring.boot.demo.yaml")
//@SuiteClasses(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={TestDogeConfig.class})
public class DogenessTestCase extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private DogeRepository dogeRepository;
	
	@Autowired
	private DogeService dogeService;
	
	@Test
	public void testDogeService(){
		Assert.assertFalse("Unit Test profile sets wow to 4, should have been false", dogeService.requiresDogeness());
	}
	
	@Test
    public void testDogeRepository() throws Exception {
        Assert.assertEquals("wow", dogeRepository.getData(), "Test Repository was not injected");
    }
	
}
