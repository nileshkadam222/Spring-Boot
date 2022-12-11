package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//define my init method
	@PostConstruct
	public void doMystartupStuff() {
		System.out.println(">> TennisCoach : inside of doMystartupStuff.");
	}
	
	//define my destroy method
	@PreDestroy
		public void doMyCleanUpStuff() {
			System.out.println(">> TennisCoach : inside of doMyCleanUpStuff.");
		}
	
	
	
	@Autowired
	public TennisCoach(@Qualifier("restFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
