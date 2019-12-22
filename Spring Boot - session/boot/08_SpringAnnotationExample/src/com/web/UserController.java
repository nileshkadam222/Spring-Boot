package com.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

 import com.domain.Community;
import com.domain.Country;
import com.domain.Department;
import com.domain.Language;
import com.domain.ServiceProvider;
import com.domain.User;
import com.service.UserService;

@Controller
@RequestMapping("/userRegistration.htm")
//@SessionAttributes("user")
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("countryList")
	public List<Country> populateCountryList() {
		return userService.getAllCountries();
	}
	
	 
	
	@ModelAttribute("communityList")
	public List<Community> populateCommunityList() {
		return userService.getAllCommunities();
	}
	
	@ModelAttribute("lan")
	public List<Language> populatLList() {
		return userService.getAlllan();
	}
	@ModelAttribute("dept")
	public List<Department> populateDept() {
		return userService.getAllDept();
	}
	@ModelAttribute("sp")
	public List<ServiceProvider> populateSp() {
		return userService.getAllServiceProvider();
	}
	
	 
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("user")User usr2) {
		//System.out.println("in1");
		
			return "userSuccess";
		
		//userService.add(user);
		//return "redirect:userSuccess.htm";
	}
	
}
