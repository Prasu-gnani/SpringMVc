package com.sathya.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springboot.repository.Productrepository;

@Service
public class Productservice {
	@Autowired
	Productrepository productRepository;

}
