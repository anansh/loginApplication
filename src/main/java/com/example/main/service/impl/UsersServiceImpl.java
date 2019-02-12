package com.example.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.Users;

import com.example.main.repository.UsersRepository;
import com.example.main.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<Users> findAll() {
		return usersRepository.findAll();
	}

	@Override
	public Users findUsersById(int id) {
		return usersRepository.findOne(id);
	}
}