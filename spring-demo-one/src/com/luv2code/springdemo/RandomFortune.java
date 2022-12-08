package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFortune implements FortuneService {

	private List<String> fortuneList = new ArrayList<>();
	
	public RandomFortune() {
		fortuneList.add("Today is your bad day.");
		fortuneList.add("Today is your good day.");
		fortuneList.add("Today is your unhappy day.");
	}
	
	
	
	@Override
	public String getFortune() {
		int randomindex = 0 + (int)(Math.random() * fortuneList.size());
		return fortuneList.get(randomindex);
	}

}
