package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		
		System.out.println(theCoach.getDailyFortune());
		
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("poinitng to the same object: "+result);
		
		System.out.println("Memory locaation for theCoach: "+theCoach);
		
		System.out.println("Memory locaation for alphaCoach: "+alphaCoach);
		
		context.close();
	}

}
