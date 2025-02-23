package com.sathya.springbootmvc.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.entity.Productentity;
import com.sathya.springbootmvc.model.Productmodel;
import com.sathya.springbootmvc.service.Productservice;

import jakarta.validation.Valid;



@Controller
public class Productcontroller {
	@Autowired
	Productservice productservice;
	
	@GetMapping("/delete/{id}")
	public String deleteproductbyid(@PathVariable Long id)
	{
		productservice.deleteproductbyid(id);
		return "redirect:/getallproducts";
	}
	
	
	@GetMapping("/search")
	public String searchid()
	{
		return "searchform";
	}
	
	@PostMapping("/searchbyid")
	public String searchbyid(@RequestParam Long id,Model model)
	{
		Productentity product = productservice.searchbyid(id);
		model.addAttribute("product",product);
		return "searchform";
	}
	
	
	@GetMapping("/getallproducts")
	public String getallproducts(Model model)
	{
		List<Productentity> products = productservice.getallproducts();
		model.addAttribute("products", products);
		return "productlist";
	}
	
	
//	@GetMapping("/productform")
//	public String getproduct(Model model)
//	{
//		return "product";
//		
//	}
//	
//	@PostMapping("/saveproduct")
//	public String saveproduct(Productmodel productmodel)
//	{
//		productservice.saveProductcontroller(productmodel);
//		return "success";
//	}
	
	
	@GetMapping("/edit/{id}")
	public String editById(@PathVariable Long id, Model model)
	{
		Productmodel product = productservice.editById(id);
		model.addAttribute("product",product);
		model.addAttribute("id", id);
		return "editform";
	}
	@PostMapping("/editproductsave/{id}")
	public String updatedata(@PathVariable Long id,Productmodel productmodel)
	{
	    productservice.updateData(id,productmodel);
		return "redirect:/getallproducts";
	}
	@GetMapping("/productform2")
	public String getproductform(Model model)
	{
		Productmodel productmodel =  new Productmodel();
		productmodel.setMadeIn("India");
		productmodel.setQuantity(2);
		productmodel.setDiscountrate(10.5);
		model.addAttribute("productmodel", productmodel);
		return "add product";
	}
	@PostMapping("/saveproductform")
	public String saveproduct(@Valid Productmodel productmodel,BindingResult bindingResult,Model model)
	{
		HashMap<String, String> validationErrors=new HashMap<String, String>();
		if(bindingResult.hasErrors())
		{
			for(FieldError fieldError:bindingResult.getFieldErrors())
			{
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			model.addAttribute("validationErrors", validationErrors);
			return "add product";
		  }
		 productservice.saveProductcontroller(productmodel);
		 return "redirect:/getallproducts";
		}
	}
	
	

