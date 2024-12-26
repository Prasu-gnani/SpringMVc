package com.sathya.springboot.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productentity {
	@Id
	
	    private long id;
	    private String name;
	    private String brand;
	    private String madein;
	    private double price;
	    private int quantity;
	    private double discountrate;
	    private double offerprice;
	    private double taxprice;
	    private double finalprice;
	    private double stockvalue;
	    
	}
