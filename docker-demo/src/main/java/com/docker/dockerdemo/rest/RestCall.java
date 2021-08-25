package com.docker.dockerdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCall {

	@GetMapping("/getName")
	public String getName() {
		return "Nilesh Kadam";
	}
}
