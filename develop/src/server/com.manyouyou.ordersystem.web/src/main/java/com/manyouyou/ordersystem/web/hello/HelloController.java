package com.manyouyou.ordersystem.web.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do")
	public String sayHello(@RequestParam(value="name",required=false,defaultValue="world" )String name,Model model){
		System.out.println("accept parameter ----" + name);
		model.addAttribute("name", name);
		return "main/hello";
	}
}
