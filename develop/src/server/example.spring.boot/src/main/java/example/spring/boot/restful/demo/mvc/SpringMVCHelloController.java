package example.spring.boot.restful.demo.mvc;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Produces(MediaType.APPLICATION_JSON)
public class SpringMVCHelloController {

	@RequestMapping(path = "/talk")
	public String talk(
			@RequestParam(value = "name", defaultValue = "world") String name) {
		return "hello " + name;
	}

	@RequestMapping("/")
	public String index() {
		return "this is the index";
	}

	private static final String template = "%s";

	private AtomicLong atoid = new AtomicLong();

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public UserModel showUser(
			@RequestParam(value = "name", defaultValue = "jackson") String name) {
		UserModel user = new UserModel(String.format(template, name),
				atoid.incrementAndGet());

		return user;
	}

}
