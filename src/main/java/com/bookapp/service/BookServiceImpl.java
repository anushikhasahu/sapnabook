package com.bookapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookDAO;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;


@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO bookDAO;

	@Override
	public void addBook(Book book) {
		bookDAO.save(book);
		
	}

	@Override
	public void updateBook(Book book) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try{
			bookDAO.save(book);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IdNotFoundException("Invalid Id/database error");
		}
		
	}

	@Override
	public void deleteBook(int bookid) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try{
			bookDAO.deleteById(bookid);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new IdNotFoundException("Invalid Id/database error");
		}
		
	}

	@Override
	public Book getBookById(int bookid) throws IdNotFoundException {
		return bookDAO.findById(bookid)
			      .orElseThrow(()->new IdNotFoundException("Invalid id..."));
	
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDAO.findAll();
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		List<Book> bookList =  bookDAO.findByAuthor(author);
		if(bookList.isEmpty()) {
			throw new AuthorNotFoundException("Author not found");
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		List<Book> bookList =  bookDAO.findByCategory(category);
		if(bookList.isEmpty()) {
			throw new CategoryNotFoundException("category not found");
		}
		return bookList;
	}

	@Override
	public List<Book> getByCatOrTitleOrAuth(String choice) throws BookNotFoundException {
		String lchoice="%"+choice+"%";
		//List<Book> bookList =  bookDAO.findByCatOrTitleOrAuth(lchoice);
	List<Book> bookList =  bookDAO.findByAuthorOrCategoryOrTitle(choice,choice,choice);
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("Book not found");
		}
		return bookList;
	}
	
	
	
	
}
