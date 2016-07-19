package example.spring.boot.restful.demo.resteasy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public interface IHelloEndPoint {
	
	/**
	 * uri:http://localhost:8080/hello/say/mac
	 * @param name
	 * @return
	 */
	@GET//必须指定是属于哪种方法GET、POST、PUT、DELETE、HEAD，否则会报：RESTEASY003815: Subresource for target class has no jax-rs annotations.: java.lang.String
	@Path("/{name}")
	public String sayHello(@PathParam("name") String name);
	
	/**
	 * uri:http://localhost:8080/hello/say?name=iuy
	 * @param name
	 * @return
	 */
	@GET
	@Path("/say")
	public String say(@QueryParam("name")String name);
}
