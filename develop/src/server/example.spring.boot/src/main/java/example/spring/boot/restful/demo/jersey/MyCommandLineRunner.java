package example.spring.boot.restful.demo.jersey;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner{
	/*
	 * (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 * 
	 * 在spring boot启动完成前，如果需要执行一些逻辑，则可以通过实现CommandLineRunner接口，该接口可以直接获
	 * 取SpringApplication启动时的参数args
	 * 
	 * 如果使用ApplicationRunner也能达到在启动完成前添加逻辑的效果，但是要想获取SpringApplication启动时的参数
	 * args则需要额外的写个Bean，使用ApplicationArguments来获取
	 * @Component
public class MyBean {

    @Autowired
    public MyBean(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
    }

}
	 */
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("exec some command before springApplicaton.run() complete....");
	}

}
