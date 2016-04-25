package example.spring.boot.restful.demo.resteasy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Path("/greeting")//resteasy 必须在类头标注路径
@Produces(MediaType.APPLICATION_JSON)
public class HelloService {
	
	@Value("${name:world}")
	private String name;
	
	@GET
	@Path("/{name}")//直接传参数，在uri中不要再?name=XXX,与jersey不同
	public String getUserName(@PathParam("name") String name){
		return name;
	}
	
	
	@GET
	@Path("/user/{name}")//直接传参数，在uri中不要再?name=XXX,与jersey不同
	public User getUser(@PathParam("name") String name){
		User u = new User(name, 11);
		return u;
	}
	
	
	@GET
	@Path("h/{name}/{id}")//传多个参数
	public String h(@PathParam("name")String name, @PathParam("id") String id){
		
		return name + " " + id;
	}
	
}
