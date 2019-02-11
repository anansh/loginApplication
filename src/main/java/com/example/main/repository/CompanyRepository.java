package com.example.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}