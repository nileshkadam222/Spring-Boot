package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		//load the spring configurstion file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//retrive bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach trackCoach = context.getBean("trackCoach",Coach.class);
		
		
		//call method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("--------------- Track coach--------------");
		//call method on bean
		System.out.println(trackCoach.getDailyWorkout());
		
		System.out.println(trackCoach.getDailyFortune());
	
		
		//close the context
		context.close();

	}

}
