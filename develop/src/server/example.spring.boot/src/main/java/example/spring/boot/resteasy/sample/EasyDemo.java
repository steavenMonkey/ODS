package example.spring.boot.resteasy.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Path("/")
@RestController
@EnableAutoConfiguration
public class EasyDemo {
	
	@GET
//	@RequestMapping("/talk/{inparam}")
	@Path("/talk/{inparam}")
	@ResponseBody
	public String talk(@PathParam("inparam") String str){
		return "hello " + str;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EasyDemo.class, args);
	}
}
