package com.employee.springbootmvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.springbootmvc.entity.Employeeentity;
import com.employee.springbootmvc.model.EmployeeModel;
import com.employee.springbootmvc.service.Employeeservice;


@Controller
public class Employee {
	@Autowired
	Employeeservice employeeservice;
	
	@GetMapping("/search")
	public String searchid()
	{
		return "searchform";
	}
	@PostMapping("/searchbyid")
	public String searchbyid(@RequestParam Long id,Model model) {
	   Employeeentity employee = employeeservice.searchbyid(id);
	   model.addAttribute("employee", employee);
	   return "searchform";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteemployeebyid(@PathVariable Long id)
	{
		employeeservice.deleteemployeebyid(id);
		return "redirect:/getallemployees";
	}
	@GetMapping("/edit/{id}")
	public String editById(@PathVariable Long id, Model model)
	{
	   EmployeeModel employee = employeeservice.editById(id);
	  
	   model.addAttribute("employee",employee);
	   return "editform";
	}
	
	
	
	@GetMapping("/getallemployees")
	public String getallemployees(Model model)
	{
		List <Employeeentity> employees = employeeservice.getallemployees();
		model.addAttribute("employees", employees);
		return "employeelist";
	}
	
	
	@GetMapping("/employee")
	public String employee()
	{
		return "employee";
	}
	@PostMapping("/saveemployee")
	public String postMethodName(EmployeeModel employeeModel)
	{	
		employeeservice.saveemployeedetails(employeeModel);
		return "success";
	}
}

