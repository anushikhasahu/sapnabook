package com.bookapp.service;

import org.springframework.stereotype.Service;

import com.bookapp.exception.UserNotFoundException;
import com.bookapp.model.User;
@Service
public class UserServiceImpl implements UserService{

	@Override
	public String validateUser(User user) throws UserNotFoundException {
		if(user.getUserName().equals("admin")&& user.getPassword().equals("admin123")) {
			return "admin";
		}else if(user.getUserName().equals("Sri")&& user.getPassword().equals("sri123")) {
			return "user";
		}else {
			throw new UserNotFoundException("Invalid username or password");
		}
	}

}
