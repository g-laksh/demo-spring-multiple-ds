package com.java.multiple.ds.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.multiple.ds.api.book.repository.BookRepository;
import com.java.multiple.ds.api.model.book.Book;
import com.java.multiple.ds.api.model.user.User;
import com.java.multiple.ds.api.user.repository.UserRepository;

@RestController
public class controller {
	@Autowired
	private BookRepository bookRepository;
	
    @Autowired
	private UserRepository userRepository;
	
	
	
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}


}