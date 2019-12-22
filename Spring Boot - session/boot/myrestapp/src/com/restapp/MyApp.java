package com.restapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyApp {
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	@ResponseBody
	public String sayWelcome(){
		return "welcome to restapp";
	}

}
