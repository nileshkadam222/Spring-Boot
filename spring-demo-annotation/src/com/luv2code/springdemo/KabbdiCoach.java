package com.luv2code.springdemo;

import java.io.Serial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KabbdiCoach implements Coach {
	
	@Autowired
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Play Kabbdi Daily.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
