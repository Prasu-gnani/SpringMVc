package com.product.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.springboot.service.Productservice;

@Controller
public class Controllerproduct{
	@Autowired
	Productservice productservice;
	@GetMapping("/product")
	public String product()
	{
		return "product";
	}
	@PostMapping("/saveproduct")
	public String postMethodName(Productservice productModel)
	{
		
		System.out.println(productModel);
		return "success";
	}
}
	

