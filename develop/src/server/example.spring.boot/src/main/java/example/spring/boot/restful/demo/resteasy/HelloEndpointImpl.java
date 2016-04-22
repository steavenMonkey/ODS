package example.spring.boot.restful.demo.resteasy;

import org.springframework.stereotype.Component;

@Component
public class HelloEndpointImpl implements IHelloEndPoint{

	@Override
	public String sayHello(String name) {
		return "hello " + name;
	}

}
