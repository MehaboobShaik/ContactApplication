package com.myproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
	@RequestMapping("/test/hello")
	public String helloWorld() {
		
		return "hello mike"; //--> /WEB_INF/view/hello.jsp
		
	}
	
}
