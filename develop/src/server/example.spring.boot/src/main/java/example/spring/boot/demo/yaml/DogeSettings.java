package example.spring.boot.demo.yaml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//当@EnableConfigurationProperties注解应用到你的@Configuration时，
//任何被@ConfigurationProperties注解的beans将自动被Environment属性配置。
//这种风格的配置特别适合与SpringApplication的外部YAML配置进行配合使用。
@EnableConfigurationProperties
@ConfigurationProperties(prefix="doge")
public class DogeSettings {
//	  wow: 10
//	  such: so
//	  very: true
	  
	private int wow;
	private String such;
	private boolean very;
	public int getWow() {
		return wow;
	}
	public void setWow(int wow) {
		this.wow = wow;
	}
	public String getSuch() {
		return such;
	}
	public void setSuch(String such) {
		this.such = such;
	}
	public boolean isVery() {
		return very;
	}
	public void setVery(boolean very) {
		this.very = very;
	}
	
	
	
}
