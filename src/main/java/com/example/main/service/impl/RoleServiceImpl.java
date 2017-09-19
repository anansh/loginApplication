package com.example.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.dao.RoleDAO;
import com.example.main.model.Role;
import com.example.main.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public Role getRoleDetailsById(int role_id) {
		Role obj = roleDAO.getRoleDetailsById(role_id);
		return obj;
	}
}