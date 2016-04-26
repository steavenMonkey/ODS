package example.spring.boot.demo.yaml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogeConfig {
	
	@Bean
	public DogeRepository dogeRepository(){
		return new ProductionDogeRepository();
	}
}
