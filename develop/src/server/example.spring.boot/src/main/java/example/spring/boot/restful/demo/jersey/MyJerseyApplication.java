package example.spring.boot.restful.demo.jersey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("example.spring.boot.restful.demo.jersey")
public class MyJerseyApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.exclude", "start/**");
		SpringApplication.run(MyJerseyApplication.class, args);
	}
}
