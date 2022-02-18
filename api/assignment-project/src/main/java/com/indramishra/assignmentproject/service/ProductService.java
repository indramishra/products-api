package com.indramishra.assignmentproject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indramishra.assignmentproject.model.Product;
import com.indramishra.assignmentproject.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
@Autowired
private ProductRepository repo;

public List<Product> findAllProduct() {
	log.info(":::::inside findAllProduct method::::");
	return repo.findAll();
}

public List<Product> findwithProductName(String productName) {
	log.info(":::::inside findwithProductName method::::");
	return repo.findByProductNameContaining(productName);
}

public List<Product> findByCategoryName(String category) {
	log.info(":::::inside findByCategoryName method::::");
	return repo.findByCategory(category);
}

public List<Product> findByNameAndCategory(String productName, String category) {
	log.info(":::::inside findByNameAndCategory method::::");
	return repo.findByProductNameContainingAndCategory(productName, category);
}


public List<Product> addProduct() {
	log.info(":::::inside addProduct method::::");
	
	List<Product> productList = Arrays.asList(
	new Product("mobile", 15000, 6, "c1"),
	new Product("mouse", 1500, 6, "c2"),
	new Product("chair", 1500, 6, "c3"),
	new Product("KeyBoard", 1500, 6, "c2")
	);
	log.info(":::::added products:::: ");
	return repo.saveAll(productList);
}
}
