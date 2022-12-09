package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public FootBallCoach() {
		System.out.println("Indside default constructur.");
	}
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Indside Setter method.");
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
