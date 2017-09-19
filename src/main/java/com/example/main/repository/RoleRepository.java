package com.example.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.main.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role, Integer> {
	Role findByRole(String role);
}