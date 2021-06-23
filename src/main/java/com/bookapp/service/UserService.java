package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.exception.UserNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.User;


public interface UserService {
	String validateUser(User user) throws UserNotFoundException;

}