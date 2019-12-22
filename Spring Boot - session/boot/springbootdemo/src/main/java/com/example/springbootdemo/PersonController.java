package com.example.springbootdemo;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
 public class PersonController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	@ResponseBody
	public String welcomeHome(){
		return "person";
	}
	
	
	private HashMap<String, Integer> hm= new HashMap<>();
	@RequestMapping(value="/create" ,method=RequestMethod.POST)
	//@ResponseBody
	public String createPerson(@RequestParam("uname") String name,@RequestParam("age") int age){
		
		hm.put(name, age);
		return "person added successfully";
		
	}
	@RequestMapping(value="/get/{uname}",method=RequestMethod.GET)
	public String getPerson(@PathVariable("uname") String name){
		
		String person="not found";
		if(hm.containsKey(name)) 			
			System.out.println(hm.get(name));
				 
		return person;
		
		
	}
	@RequestMapping(value="/delete/{uname}", method=RequestMethod.DELETE)
	//@ResponseBody
	public String deletePerson(@PathVariable("uname") String name) {
		
		hm.remove(name);
		return "person is removed";
	}
	@RequestMapping(value="/update/{uname}/{age}", method=RequestMethod.PUT)
	//@ResponseBody
	public String updatePerson(@PathVariable("uname")String name,@PathVariable("age") int age){
		hm.remove(name);
		hm.put(name, age);
		return "person is updated";
	}
	

}
