package com.example.main.service;

import com.example.main.model.TempTable;

public interface TempService {
	
	public TempTable insertIntoTemp(TempTable id);

	public TempTable getOneData(int id);
}