package example.spring.boot.restful.demo.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Path("/greeting")
public class HelloService {
	
	@Value("${name:world1}")
	private String name;
	
	@GET
	public String greeting(){
		return "hello2 " + name; 
	}
	
}
