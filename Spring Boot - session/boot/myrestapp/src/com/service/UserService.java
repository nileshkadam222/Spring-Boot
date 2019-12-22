package com.service;

import java.util.List;

 import com.domain.Community;
import com.domain.Country;
import com.domain.Department;
import com.domain.Language;
import com.domain.ServiceProvider;
import com.domain.User;

public interface UserService {

	public void add(User user);
	public List<Country> getAllCountries();
	public List<Community> getAllCommunities();
	public List<Language> getAlllan();
	public List<Department> getAllDept();
	public List <ServiceProvider> getAllServiceProvider();
	
}
