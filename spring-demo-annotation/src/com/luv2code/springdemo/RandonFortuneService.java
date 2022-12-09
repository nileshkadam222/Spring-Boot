package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RandonFortuneService implements FortuneService {

private List<String> fortuneList = new ArrayList<>();
	
	public RandonFortuneService() {
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
