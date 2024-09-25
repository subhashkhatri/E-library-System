package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Category;
import com.lms.repository.CategoryRepository;

@Service
public class CategoryService {
	
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
    
    public Category findByCategoryName(String category)
    {
    	return categoryRepository.findByName(category);
    }
}

