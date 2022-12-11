package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoDemoApp {
	public static void main(String args[]) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach footBallCoach = context.getBean("footBallCoach",Coach.class);
	
		Coach kabbdiCoach = context.getBean("kabbdiCoach",Coach.class);
		
		
		System.out.println("---------- Tenies ------------------------------");
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
	
		System.out.println("---------- FootBall ------------------------------");
		System.out.println(footBallCoach.getDailyWorkout());
		
		System.out.println(footBallCoach.getDailyFortune());
	

		System.out.println("---------- Kabbdi ------------------------------");
		System.out.println(kabbdiCoach.getDailyWorkout());
		
		System.out.println(kabbdiCoach.getDailyFortune());
	
		
		context.close();
	}
}
