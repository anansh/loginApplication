package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.model.User;
import com.example.main.repository.UserRepository;

@RestController
public class TestController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/welcome")
	public String welcome() {
		return "This is something";
	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
