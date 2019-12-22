package com.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.EmployeeRepository;
import com.model.Employee;

 
@Controller
public class EmployeeController {

	@PersistenceContext
	private EntityManager employeeRepository;

	@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.POST)
	public String newEmployee(Employee employee) {

		employeeRepository.persist(employee);
		return ("redirect:/listEmployees.html");

	}
	

	@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.GET)
	public ModelAndView addNewEmployee() {

		Employee emp = new Employee();
		return new ModelAndView("newEmployee", "form", emp);

	}

	@RequestMapping(value = "/listEmployees.html", method = RequestMethod.GET)
	public ModelAndView employees() {
		//List<Employee> allEmployees = employeeRepository.f();
		//return new ModelAndView("allEmployees", "employees", allEmployees);
		return null;

	}

}
