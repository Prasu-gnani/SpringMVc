package com.sathya.springbootmvc.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Productentity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	    private String name;
	    private String brand;
	    private String madein;
	    private double price;
	    private int quantity;
	    private double discountrate;
	    private double discountprice;
	    private double offerprice;
	    private double taxrate;
	    private double finalprice;
	    private double stockvalue;
	    
}
