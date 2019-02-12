package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.main.model.Users;

@Repository("UsersRepository")
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
