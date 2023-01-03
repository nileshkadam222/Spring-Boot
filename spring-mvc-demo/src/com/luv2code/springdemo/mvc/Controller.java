package com.luv2code.springdemo.mvc;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
}
