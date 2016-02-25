package com.manyouyou.ordersystem.web.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manyouyou.ordersystem.commons.ResponseConstant;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do")
	public String sayHello(@RequestParam(value="name",required=false,defaultValue="world" )String name,Model model){
		System.out.println("accept parameter ----" + name);
		model.addAttribute("name", name);
		return "main/hello";
	}
	
	
	@RequestMapping("/hello2.do")
	public String hello2(@RequestParam(value="name",required=false,defaultValue="world" )String name,ModelMap map){
		
		System.out.println(name);
		
		map.addAttribute("name2", "world2");
		
		map.addAttribute(ResponseConstant.RSP_ATTR_LOGIN_ERROR, "error msg");
		
		return "view/main/hello";
	}
}
