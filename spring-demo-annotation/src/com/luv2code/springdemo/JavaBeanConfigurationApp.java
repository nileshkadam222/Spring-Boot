package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBeanConfigurationApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		Coach theCoach = contex.getBean("swimCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());

	}

}
