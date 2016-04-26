package example.spring.boot.demo.yaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("example.spring.boot.demo.yaml")
@SpringBootApplication
public class SuchApplication implements CommandLineRunner{
	
	@Autowired
	private DogeService dogeService;
	
	@Override
	public void run(String... args) throws Exception {
		if(dogeService.requiresDogeness()){
			System.out.println(dogeService.leDoge());
		}else{
			System.out.println("dogeService don't required");
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SuchApplication.class, args);
	}

}
