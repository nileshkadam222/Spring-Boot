package com.restapp;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/welcome")
public class ReastApp {
	HashMap hm= new HashMap<>();
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	//@ResponseBody
	public String sayWelcome(){
		return "login";
	}
	@RequestMapping(value="/loginvalid", method=RequestMethod.POST)
	@ResponseBody
	public String validateUser( @RequestParam("uname") String name,@RequestParam("pwd") String pass){
		 hm.put(name, pass);
		
		return name + "added";
	}
	@RequestMapping(value="/loginvalid/{username}", method=RequestMethod.POST)
	public String searchUser(){
		
	}
}
