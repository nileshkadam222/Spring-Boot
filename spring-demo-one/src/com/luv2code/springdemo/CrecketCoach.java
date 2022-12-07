package com.luv2code.springdemo;

public class CrecketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String emailAddress;
	
	private String teamName;
	

	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside setting emailAddress method. "+emailAddress);
		this.emailAddress = emailAddress;
	}

	public void setTeamName(String teamName) {
		System.out.println("Inside setting team method. " + teamName);
		this.teamName = teamName;
	}

	public CrecketCoach() {
		System.out.println("Inside No-Args constructor.");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside Setter method.");
		this.fortuneService = fortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Practies fast ball for 15 min.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
