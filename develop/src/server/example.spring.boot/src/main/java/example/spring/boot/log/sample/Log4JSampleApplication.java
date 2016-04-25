package example.spring.boot.log.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("example.spring.boot.log.sample")
@SpringBootApplication
public class Log4JSampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Log4JSampleApplication.class, args);
	}
}
