package com.example.main.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.main.model.TempTable;

public interface TempRepository extends JpaRepository<TempTable, Serializable> {

}