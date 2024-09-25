package com.lms.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.dto.BookDTO;
import com.lms.entity.Book;
import com.lms.entity.User;
import com.lms.service.BookService;
import com.lms.service.CategoryService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String listBooks(Model model , HttpSession session) {
		List<Book> books = bookService.findAll();
		session.setAttribute("user", session.getAttribute("user"));
		model.addAttribute("books", books);
		return "books";
	}
	
	
	
	@GetMapping("/add")
	public String showAddBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryService.findAll());
		return "add-book";
	}

	@PostMapping("/add")
	public String addBook(@ModelAttribute BookDTO bookDTO, HttpSession session) {
		
		Book book = new Book();
		BeanUtils.copyProperties(bookDTO, book );
		book.setCategory(categoryService.findByCategoryName(bookDTO.getCategory()));
		User user = (User)session.getAttribute("user");
		System.err.println(user.getId());
		book.setUser(user);
		bookService.save(book);
		return "redirect:/books";
	}

	@GetMapping("/borrow/{id}")
	public String borrowBook(@PathVariable Long id) {
		Book book = bookService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		book.setBorrowed(true);
		bookService.save(book);
		return "redirect:/books";
	}

	@GetMapping("/return/{id}")
	public String returnBook(@PathVariable Long id) {
		Book book = bookService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		book.setBorrowed(false);
		bookService.save(book);
		return "redirect:/books";
	}
	
	@GetMapping("/findedCategories/{categoryName}")
    public String findByCategory(@PathVariable(name = "categoryName") String category,Model model)
    {
    	 model.addAttribute("books", bookService.findByCategory(category));
    	 return "books";
    }
}