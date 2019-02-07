package com.example.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.main.model.Role;
import com.example.main.model.User;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	List<Role> findAll();
}