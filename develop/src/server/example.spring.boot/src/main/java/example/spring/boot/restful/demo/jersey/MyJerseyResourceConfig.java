package example.spring.boot.restful.demo.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class MyJerseyResourceConfig extends ResourceConfig{
	/*
	 * 适用jersey restful 框架来搭建spring boot应用，需要注册action controller
	 */
	public MyJerseyResourceConfig(){
		register(HelloService.class);
	}
	
}
