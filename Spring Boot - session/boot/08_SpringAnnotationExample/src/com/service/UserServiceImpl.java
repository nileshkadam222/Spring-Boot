package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.*;
@Service
public class UserServiceImpl implements UserService {

	@Override
	public void add(User user) {
		//Persist the user object here. 
		System.out.println("User added successfully");

	}

	@SuppressWarnings("unchecked")
	@Override
	public List getAllCountries() {
		List countryList = new ArrayList();
		countryList.add(new Country(1,"India"));
		countryList.add(new Country(2,"USA"));
		countryList.add(new Country(3,"UK"));
		return countryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getAllCommunities() {
		List communityList = new ArrayList();
		communityList.add(new Community("Spring","Spring"));
		communityList.add(new Community("Hibernate","Hibernate"));
		communityList.add(new Community("Struts","Struts"));
		return communityList;
	}

	@Override
	public List<Language> getAlllan() {
		List ls = new ArrayList();
		ls.add(new Language("hindi","hindi"));
		ls.add(new Language("english","english"));
		return ls;
	}

	@Override
	public List<Department> getAllDept() {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		 ls.add(new Department("IT", "IT"));
		 ls.add(new Department("sales", "sales"));
		 return ls;
	}

	@Override
	public List<ServiceProvider> getAllServiceProvider() {
		List ls = new ArrayList();
		ls.add(new ServiceProvider("airtel", "airtel"));
		ls.add(new ServiceProvider("verizon", "verizon"));

		return ls;
	}
	
	
	

}
