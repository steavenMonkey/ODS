package example.log.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JTestCase {
	
	private Logger logger = LoggerFactory.getLogger(SLF4JTestCase.class);
	
	@Test
	public void testLogInfo(){
		logger.info("slf4j info");//读取src/main/java下的log4j.properties配置文件
	}
}
