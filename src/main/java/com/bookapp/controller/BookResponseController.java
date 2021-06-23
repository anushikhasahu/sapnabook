package com.bookapp.controller;

import java.util.List
;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.exception.UserNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.User;
import com.bookapp.service.BookService;
import com.bookapp.service.UserService;



@RestController
@RequestMapping("book-api")
public class BookResponseController {


	@Autowired
	BookService bookService;
	@PostMapping("/books")
	ResponseEntity<Void> addBook(Book book) {
		System.out.println(book);
		bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping("/books")
	ResponseEntity<Void> updateBook(Book book)throws IdNotFoundException{
		System.out.println("put "+book);
		bookService.updateBook(book);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/books/{bookid}")
	ResponseEntity<Void>  deleteBook(@PathVariable("bookid")int bookid)throws IdNotFoundException{
		System.out.println("delete");
		bookService.deleteBook(bookid);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAllBooks(){
		List<Book> bookList = bookService.getAllBooks();
		return ResponseEntity.ok(bookList);
	}
	@GetMapping("/books-by-id/{bookid}")
	Book getBookById(@PathVariable("bookid") int bookid) throws IdNotFoundException{
		return bookService.getBookById(bookid);
	}
	
	@GetMapping("/books-by-author/{author}")
	ResponseEntity<List<Book>> getBookByAuthor(@PathVariable("author")String author) throws AuthorNotFoundException{
		List<Book> bookList = bookService.getBookByAuthor(author);
		return ResponseEntity.ok(bookList);
	}
	@GetMapping("/books-by-category/{category}")
	ResponseEntity<List<Book>> getBookByCategory(@PathVariable("category")String category) throws CategoryNotFoundException{
		List<Book> bookList = bookService.getBookByCategory(category);
		return ResponseEntity.ok(bookList);
	}
	@GetMapping("/books-by-choice/{choice}")
	ResponseEntity<List<Book>> getByCatOrTitleOrAuth(@PathVariable("choice") String choice) throws BookNotFoundException{
		List<Book> bookList = bookService.getByCatOrTitleOrAuth(choice);
		return ResponseEntity.ok(bookList);
	}
	
	
	
	
}

