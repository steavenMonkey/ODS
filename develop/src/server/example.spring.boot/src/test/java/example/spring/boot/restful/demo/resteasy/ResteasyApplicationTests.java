package example.spring.boot.restful.demo.resteasy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ResteasyApplication.class)
//@WebAppConfiguration表示使用WebApplicationContext来加在web 应用的资源文件，默认路径是src/main/webapp，可以通过value属性来更改
//@WebAppConfiguration 必须同@ContextConfiguration一起使用
@WebAppConfiguration
//@IntegrationTest表示集成测试，即测试需要像应用一样完全启动，通常同@SpringApplicationConfiguration一起使用，如果使用了@WebAppConfiguration，建议使用@WebIntegrationTest
@IntegrationTest("server.port:0")
public class ResteasyApplicationTests {
	
	@Value("${local.server.port}")
	private int port;
	
	@Value("${name:hello world}")
	private String testName;
	
	@Test
	public void testGetUserName(){
		TestRestTemplate testRestTemp =  new TestRestTemplate();
		ResponseEntity<String> response = testRestTemp.getForEntity("http://localhost:" + port + "/greeting/" + testName , String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("hello world", response.getBody());
	}
	
	
}
