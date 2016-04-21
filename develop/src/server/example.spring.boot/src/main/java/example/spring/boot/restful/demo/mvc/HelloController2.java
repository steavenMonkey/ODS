package example.spring.boot.restful.demo.mvc;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {
	
	private static final String template = "%s";
	
	private AtomicLong atoid = new AtomicLong();
	
	@RequestMapping(path="/hello", method=RequestMethod.GET)
	public UserModel showUser(@RequestParam(value="name", defaultValue="jackson") String name){
		UserModel user = new UserModel(String.format(template, name), atoid.incrementAndGet());
		
		return user;
	}
	
//	@RequestMapping(path="/hello", method=RequestMethod.POST)
	@GET
	@Path("/hello2/{name2}")
	public UserModel showUser2(@PathParam(value="name2") String name){
		UserModel user = new UserModel(String.format(template, name), atoid.incrementAndGet());
		
		return user;
	}
	
	
}	
