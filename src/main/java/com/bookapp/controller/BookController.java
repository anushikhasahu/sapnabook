package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.User;
import com.bookapp.service.BookService;


//@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	@PostMapping("/books")
	void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	@PutMapping("/books")
	void updateBook(@RequestBody Book book)throws IdNotFoundException{
		bookService.updateBook(book);
	}
	@DeleteMapping("/books")
	void deleteBook(int bookid)throws IdNotFoundException{
		bookService.deleteBook(bookid);
	}
	@GetMapping("/books")
	List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	@GetMapping("/books-by-id/{bookid}")
	Book getBookById(@PathVariable("bookid") int bookid) throws IdNotFoundException{
		return bookService.getBookById(bookid);
	}
	
	@GetMapping("/books-by-author/{author}")
	List<Book> getBookByAuthor(@PathVariable("author")String author) throws AuthorNotFoundException{
		return bookService.getBookByAuthor(author);
	}
	@GetMapping("/books-by-category/{category}")
	List<Book> getBookByCategory(@PathVariable("category")String category) throws CategoryNotFoundException{
		return bookService.getBookByCategory(category);
	}
	@GetMapping("/books-by-choice/{choice}")
	List<Book> getByCatOrTitleOrAuth(@PathVariable("choice") String choice) throws BookNotFoundException{
		return bookService.getByCatOrTitleOrAuth(choice);
	}
	
	
	
	
	
	
	
	

	
	
	
		
	
}
