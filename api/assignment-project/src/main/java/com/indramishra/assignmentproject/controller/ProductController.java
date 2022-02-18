package com.indramishra.assignmentproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.indramishra.assignmentproject.exceptionhandler.ProductNotFoundException;
import com.indramishra.assignmentproject.model.Product;
import com.indramishra.assignmentproject.service.ProductService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j

public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@CrossOrigin
	@GetMapping("/getProducts")
	public ResponseEntity<List<Product>> getProductList(@RequestParam(name = "productName", required = false) String productName,
			@RequestParam(name = "category", required = false) String category) {
		log.info(":::::getProductList method started::::");
		List<Product> productList = new ArrayList<Product>();
		String[] categoryArr;
		
		if(productName == null && category == null) {
			 pService.findAllProduct().forEach(productList::add);
			 if(productList.isEmpty() || productList.size()<1) {
				 log.error("Product not found exception");
				 throw new ProductNotFoundException();
				 
			 }
		} 
		
		if(productName != null && category == null) {
			pService.findwithProductName(productName).forEach(productList::add);
			if(productList.isEmpty() || productList.size()<1) {
				log.error("Product not found exception for:::: "+productName);
				 throw new ProductNotFoundException();
			 }
		}
		if(category != null && productName == null) {
			categoryArr = category.split(",");
			for(String cat : categoryArr) {
				pService.findByCategoryName(cat).forEach(productList::add);
			}
			if(productList.isEmpty() || productList.size()<1) {
				log.error("Product not found exception for:::: "+category);
				 throw new ProductNotFoundException();
			 }
		}
		
		if(productName != null && category != null) {
			categoryArr = category.split(",");
			
			for(String cat : categoryArr) {
				pService.findByNameAndCategory(productName, cat).forEach(productList::add);
			}
			if(productList.isEmpty() || productList.size()<1) {
				log.error("Product not found exception for:::: "+category+" and "+productName);
				 throw new ProductNotFoundException();
			 }
			
		} 
		
		log.info(":::::end of getProductList method::::");
		
		return ResponseEntity.ok().body(productList);
		
		
		
	}
	
	@PostMapping("/addProduct")
	public List<Product> addProduct() {
		return pService.addProduct();
	}

}
