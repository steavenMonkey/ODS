package example.spring.boot.restful.demo.resteasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("example.spring.boot.restful.demo.resteasy")
@SpringBootApplication
public class ResteasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResteasyApplication.class, args);
	}
}
