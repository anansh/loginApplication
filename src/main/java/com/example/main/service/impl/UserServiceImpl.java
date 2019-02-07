package com.example.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.main.model.User;
import com.example.main.repository.UserRepository;
import com.example.main.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserById(int email) {
		return userRepository.findById(email);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}