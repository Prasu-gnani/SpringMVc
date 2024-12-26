package com.employee.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.springbootmvc.entity.Employeeentity;

public interface Employeerepository extends JpaRepository<Employeeentity, Long>
{

}
