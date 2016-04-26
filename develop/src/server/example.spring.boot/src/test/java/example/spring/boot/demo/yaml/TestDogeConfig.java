package example.spring.boot.demo.yaml;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("unit-test")
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class TestDogeConfig {
	
	@Bean
	public DogeRepository dogeRepository(){
		return new TestDogeRepository();
	}
}
