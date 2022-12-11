package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	

	@Value("${foo.team}")
	private String team;
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;

	}

	@Override
	public String getDailyWorkout() {
		System.out.println("Email : " + email);
		System.out.println("Team : " + team);
		return "Swim for 200 metter.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
