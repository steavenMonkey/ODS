package training.example.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	/*
	 * 使用注解的方式注册bean，配合AnnotationConfigApplicationContext使用
	 */
	
	@Bean
	public StudentBean studentBean(){
		return new StudentBean();
	}
	
	@Bean
	public StudentWiredBean studentWiredBean(){
		return new StudentWiredBean(new StudentBean());
	}
}
