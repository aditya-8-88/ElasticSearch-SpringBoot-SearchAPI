package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;

	public Iterable<Product> getProduct() {
		return productRepo.findAll();
	}

	public Product insertProduct(Product product) {
		return productRepo.save(product);
	}

	public Product updateProduct(Product product, int id) {
		Product product1 = productRepo.findById(id).get();
		product1.setInfo(product.getInfo());
		return product1;
	}
	
//	public Product updateProduct(Product product, int id) {
//        Optional<Product> existingProduct = productRepo.findById(id);
//        if (existingProduct.isPresent()) {
//            Product productToUpdate = existingProduct.get();
//            productToUpdate.setInfo(product.getInfo());
//            // Update other fields as needed
//            return productRepo.save(productToUpdate);  // Persist changes
//        } else {
//            // Handle the case where the product with the given ID does not exist
//            throw new RuntimeException("Product not found with id " + id);
//        }
//    }

	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}
}
