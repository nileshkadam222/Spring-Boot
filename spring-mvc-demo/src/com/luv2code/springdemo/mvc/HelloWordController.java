package com.luv2code.springdemo.mvc;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWordController {
	
	@RequestMapping("/showform")
	public String showForm() {
		return "helloword-form";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String showWelcome(ModelAttribute modelAttribute) {
		return "welcome";
	}

}
