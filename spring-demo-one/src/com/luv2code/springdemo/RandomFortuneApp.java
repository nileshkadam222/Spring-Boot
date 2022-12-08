package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomFortuneApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("basketBallCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getDailyFortune());

	}

}
