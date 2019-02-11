package com.example.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.main.model.Company;
import com.example.main.repository.CompanyRepository;
import com.example.main.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
}