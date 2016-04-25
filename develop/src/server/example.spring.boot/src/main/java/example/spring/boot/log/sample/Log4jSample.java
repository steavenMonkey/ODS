package example.spring.boot.log.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Path("/log")
public class Log4jSample {
	
	private Logger logger = LoggerFactory.getLogger(Log4jSample.class);
	
	@GET
	public String log(){
		logger.info("this is log4jSample info..............");
		logger.error("{}{}","use {} to log error info", " ,second {}");//{} 为占为符 "," 后面紧跟占位符的具体内容
		Exception e = new Exception("exception....");
		logger.error("log error{}", ",EventID=000000", e);
		return "log4j sample works";
	}
}
