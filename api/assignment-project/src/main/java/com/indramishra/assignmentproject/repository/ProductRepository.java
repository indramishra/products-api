package com.indramishra.assignmentproject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indramishra.assignmentproject.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAll();
	List<Product> findByProductNameContaining(String productName);
	List<Product> findByCategory(String category);
	List<Product> findByProductNameContainingAndCategory(String productName, String category);
}
