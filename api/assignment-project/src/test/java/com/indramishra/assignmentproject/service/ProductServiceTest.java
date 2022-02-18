package com.indramishra.assignmentproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.indramishra.assignmentproject.model.Product;
import com.indramishra.assignmentproject.repository.ProductRepository;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService service;
	
	@Mock
	private ProductRepository repo;
	
	@Test
	public void fillAllProductTest() {
		when(repo.findAll()).thenReturn(Arrays.asList(new Product(1L, "mobile", 15000, 6, "c1"),
				new Product(2L, "mouse", 1500, 6, "c2"),
				new Product(3L, "chair", 1500, 6, "c3")));
		
		List<Product> list = service.findAllProduct();
		assertEquals(3, list.size());
	}
	
}
