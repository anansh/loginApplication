package com.example.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.main.model.Users;

@Repository("UsersRepository")
public interface UsersRepository extends JpaRepository<Users, Integer> {
	List<Users> findAll();
}
