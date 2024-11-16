package com.express.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.express.entities.Category;
import com.express.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}
}
