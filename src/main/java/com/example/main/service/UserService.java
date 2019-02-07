package com.example.main.service;

import java.util.List;

import com.example.main.model.User;

public interface UserService {
	public User findUserById(int userId);

	List<User> findAll();
}