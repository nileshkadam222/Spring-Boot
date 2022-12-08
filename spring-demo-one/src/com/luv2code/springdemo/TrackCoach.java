package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a had 5K";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	
	//init method bean lifecycle
	public void doMyStartupStuff() {
		System.out.println("TrackCoach : inside doMyStartupStuff");
	}
	
	public void doMyCleanUpstuff() {
		System.out.println("TrackCoach : inside doMyCleanUpstuff");
	}

}
