package com.example.main.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.model.TempDetails;

public interface TempDetailsRepository extends JpaRepository<TempDetails, Serializable>{

}