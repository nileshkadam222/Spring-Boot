package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public FootBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Make 20 goles to win";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
