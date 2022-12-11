package com.luv2code.springdemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	
	private String fileFortune;
	@PostConstruct
	public void setUpFortune() throws IOException {
		System.out.println("Reading fortune form file.");
		this.fileFortune = new String(Files.readAllBytes(Paths.get("E:\\Spring Boot\\spring-demo-annotation\\src\\fortune.txt")));
	}

	@Override
	public String getFortune() {
		return fileFortune;
	}

}
