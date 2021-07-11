package com.alpha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alpha.demo.model.Employee;
import com.alpha.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	
	@GetMapping("/")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/home")
	public String viewHome(@RequestParam("id")long id) {
		if(employeeService.getId(id)!=null)
		{
			return "home";
		}
		return "error";
	}
	
	
	
	
	@GetMapping("/index")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		
		
		
		return "index";
		
		
			
	
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployee(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/forDelete")
	public String deleteEmployee()
	{
		
		return "delete";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id")long id)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
	
	@GetMapping("/updateEmployeeForm")
	public String updateEmployee(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "update";
	}
}
