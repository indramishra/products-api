package com.indramishra.assignmentproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long proctId;
	private String productName;
	private double productPrice;
	private int productQuantity;
	private String category;
	
	public Product(String productName, double productPrice, int productQuantity, String category) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.category = category;
				
	}
}
