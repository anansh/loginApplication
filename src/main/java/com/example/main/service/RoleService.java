package com.example.main.service;

import java.util.List;

import com.example.main.model.Role;

public interface RoleService {

	List<Role> findAll();

	Role findRoleNativeQuery();

	Role findRoleByRoleId(int roleId);

}