package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
	
	Category findByName(String name);

}
