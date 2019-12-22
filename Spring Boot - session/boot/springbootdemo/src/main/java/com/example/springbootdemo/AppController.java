package com.example.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
@RequestMapping(value="/home",method=RequestMethod.GET)
	@ResponseBody
	public String welcomeHome(){
		return "welcome to Spring Boot";
	}

}
