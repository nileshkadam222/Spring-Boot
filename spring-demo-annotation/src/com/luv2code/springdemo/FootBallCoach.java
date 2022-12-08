package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Make 20 goles to win";
	}

}
