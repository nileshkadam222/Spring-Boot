package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 
//@Controller
@RestController
public class MyRestApp {
	@GetMapping("/welcome")
	//@ResponseBody
	public String sayHello(){
		return "welcome to rest App";
	}
	
	

}
