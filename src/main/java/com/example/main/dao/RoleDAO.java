package com.example.main.dao;

import com.example.main.model.Role;

public interface RoleDAO {
	Role getRoleDetailsById(int role_id);
	
	Role getRoleByHQL(String table,String condition);
}