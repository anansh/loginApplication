package com.example.main.service;

import java.util.List;

import com.example.main.model.Users;

public interface UsersService {

	List<Users> findAll();

	Users findUsersById(int id);

}