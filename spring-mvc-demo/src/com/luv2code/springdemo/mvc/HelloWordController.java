package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWordController {
	
	@RequestMapping("/showform")
	public String showForm() {
		return "helloword-form";
	}
	
	@RequestMapping(value = "/welcome")
	public String showWelcome() {
		return "welcome";
	}
	
	@RequestMapping("/processFromVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model) {
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Yo "+ theName;
		
		model.addAttribute("message", result);
		
		return "welcome";
	}
	
	@RequestMapping("/processFromVersionThree")
	public String processFromVersionThree(@RequestParam(value = "studentName",required = true) String studentName,Model model) {
		
		
		studentName = studentName.toUpperCase();
		
		String result = "Hi "+ studentName;
		
		model.addAttribute("message", result);
		
		return "welcome";
	}
	

}
