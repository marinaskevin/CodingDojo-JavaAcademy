package com.marinaskevin.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.marinaskevin.relationships.models.Category;
import com.marinaskevin.relationships.models.Product;
import com.marinaskevin.relationships.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> allProducts() { 
		return this.productRepository.findAll();
	}
	
	public Product createProduct(Product p) {
		return this.productRepository.save(p);
	}
	
	public Product addCategory(Product p, Category c) {
		p.getCategories().add(c);
		return this.productRepository.save(p);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = this.productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
}
