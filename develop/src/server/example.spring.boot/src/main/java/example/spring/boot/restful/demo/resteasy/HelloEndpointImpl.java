package example.spring.boot.restful.demo.resteasy;

import org.springframework.stereotype.Component;

@Component
public class HelloEndpointImpl implements IHelloEndPoint{

	@Override
	public String sayHello(String name) {
		return "hello " + name;
	}

	/* (non-Javadoc)
	 * @see example.spring.boot.restful.demo.resteasy.IHelloEndPoint#say(java.lang.String)
	 */
	@Override
	public String say(String name) {
		// TODO Auto-generated method stub
		return name;
	}

}
