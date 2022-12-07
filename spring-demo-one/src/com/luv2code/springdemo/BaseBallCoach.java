package com.luv2code.springdemo;

public class BaseBallCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public BaseBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "spend 30 min on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
