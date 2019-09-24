package com.marinaskevin.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.marinaskevin.relationships.models.Category;
import com.marinaskevin.relationships.models.Product;
import com.marinaskevin.relationships.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> allCategories() {
		return this.categoryRepository.findAll();
	}
	
	public Category createCategory(Category c) {
		return this.categoryRepository.save(c);
	}
	
	public Category addProduct(Category c, Product p) {
		c.getProducts().add(p);
		return this.categoryRepository.save(c);
	}

	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = this.categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
}
