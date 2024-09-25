package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Book;
import com.lms.entity.Category;

public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByCategory(Category category);

}
