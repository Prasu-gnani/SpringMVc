package com.employee.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.springbootmvc.entity.Employeeentity;
import com.employee.springbootmvc.model.EmployeeModel;
import com.employee.springbootmvc.repository.Employeerepository;

@Service
public class Employeeservice {
	@Autowired
	Employeerepository employeerepository;
	
	public Employeeentity searchbyid(Long id) {
		Optional<Employeeentity> OptionalData = employeerepository.findById(id);
		if(OptionalData.isPresent())
		{
			Employeeentity employee = OptionalData.get();
			return employee;
		}
		else
		{
			return null;
		}
	}
	
	public void deleteemployeebyid(Long id) {
		
		employeerepository.deleteById(id);
	}

	 public List<Employeeentity> getallemployees(){
		 List<Employeeentity> employees = employeerepository.findAll();
		 return employees;
	 }
	public void saveemployeedetails(EmployeeModel employeeModel)
	{
		double allowance;
		double bonus;
		double medicalinsurance;
		double basicsalary;
		double monthlysalary;
		
		if(employeeModel.getSalary()<=350000)
		{
			bonus=10000;
			allowance=2000;
			medicalinsurance=50000;
			basicsalary=employeeModel.getSalary()-bonus-allowance-medicalinsurance;
		}
		else if(employeeModel.getSalary()>35000 && employeeModel.getSalary()<1000000)
		{
			bonus=60000;
			allowance=4000;
			medicalinsurance=50000;
			basicsalary=employeeModel.getSalary()-bonus-allowance-medicalinsurance;
		}
		else
		{
			bonus=100000;
			allowance=7000;
			medicalinsurance=70000;
			basicsalary=employeeModel.getSalary()-bonus-allowance-medicalinsurance;
		}
		
		monthlysalary=(int)employeeModel.getSalary()/12;
		Employeeentity employeeentity = new Employeeentity();
		employeeentity.setName(employeeModel.getName());
		employeeentity.setAge(employeeModel.getAge());
		employeeentity.setDepartment(employeeModel.getDepartment());
		employeeentity.setSalary(employeeModel.getSalary());
		employeeentity.setLocation(employeeModel.getLocation());
		employeeentity.setGender(employeeModel.getGender());
		employeeentity.setMonthsalary(monthlysalary);
		employeeentity.setBasicsalary(basicsalary);
		employeeentity.setAllowance(allowance);
		employeeentity.setBonus(bonus);
		employeeentity.setMedicalinsurance(medicalinsurance);
		employeerepository.save(employeeentity);
		
		 }
	
      public EmployeeModel editById(Long id)
     {
    	 Optional<Employeeentity> optionaldata = employeerepository.findById(id);
    	 EmployeeModel employee = new EmployeeModel();
    	 if(optionaldata.isPresent())
    	 {
    		Employeeentity eemployee  = optionaldata.get();
    		employee.setName(eemployee.getName());
    		employee.setAge(eemployee.getAge());
    		employee.setDepartment(eemployee.getDepartment());
    		employee.setSalary(eemployee.getSalary());
    		employee.setLocation(eemployee.getLocation());
    		employee.setGender(eemployee.getGender());
    		return employee;
    	 }
    	 else
    	 {
    		 return null;
    	 }
    	 
     }
 }
    
