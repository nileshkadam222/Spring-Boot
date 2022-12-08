package com.luv2code.springdemo;

public class BasketBallCoach implements Coach {

	private FortuneService fortuneService;
	
	public BasketBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Jump 200 times";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
