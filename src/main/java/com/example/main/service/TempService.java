package com.example.main.service;

import java.util.List;

import com.example.main.model.TempTable;

public interface TempService {
	
	public TempTable insertIntoTemp(TempTable id);

	public TempTable getOneData(int id);
	
	public List<TempTable> retriveAllUsers();
	
	public TempTable deleteOneData(int id);
}