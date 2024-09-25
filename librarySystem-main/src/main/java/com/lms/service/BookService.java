package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lms.entity.Book;
import com.lms.entity.Category;
import com.lms.repository.BookRepository;
import com.lms.repository.CategoryRepository;

@Service
public class BookService {
	
	@Autowired
    private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}
    public List<Book> findByCategory(String category)
    {
    	
    	return bookRepository.findByCategory(categoryRepository.findByName(category));
    }
}
