package com.sathya.springbootmvc.model;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productmodel {
	@NotBlank(message=" name cannot be blank")
		private String name;
	@NotBlank(message=" brand cannot be blank")
		private String brand;
	@NotBlank(message="madeIn cannot be blank")
		private String madeIn;
	@Positive(message="price cannot be less than zero")
		private double price;
	@Min(value = 1, message="quantity atleast one")
		private int quantity;
	@DecimalMax(value = "100.0" ,message="discountrate cannot be exceed 100.0")
		private double discountrate;
		private double taxrate;
		

	}


