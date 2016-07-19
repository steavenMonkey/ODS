package example.spring.boot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ComponentScan("example.spring.boot.thymeleaf")
@EnableAutoConfiguration
public class SampleController {

	/*
	 * 所有Thymeleaf的相关依赖都会被加载到类路径中，
	 * 更重要的是，上文中所有TemplateEngine，
	 * ThymeleafViewResolver等bean都在应用启动后被自动实例化，
	 * 默认情况下模板的目录位于src/main/resources/templates/文件夹中，
	 * 所以开发者只需要在这个文件夹中添加模板文件即可。
	 */
	
    @RequestMapping("/")
//    @ResponseBody 这个表示以他自己为返回值
    String hello(ModelMap map) {
    	map.addAttribute("name", "jackson");
        return "hello";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
