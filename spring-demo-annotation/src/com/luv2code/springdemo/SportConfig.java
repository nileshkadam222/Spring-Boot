package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.luv2code.springdemo")
public class SportConfig {

	
	public FortuneService fortuneService() {
		return new RandonFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(fortuneService());
	}
}
