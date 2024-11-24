package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/apis")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/findAll")
	Iterable<Product> findAll(){
		return productService.getProduct();
	}
	
	@PostMapping("/insert")
	Product insertProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}
	
}
