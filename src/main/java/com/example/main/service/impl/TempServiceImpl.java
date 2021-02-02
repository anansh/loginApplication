package com.example.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.TempTable;
import com.example.main.repository.TempRepository;
import com.example.main.service.TempService;

@Service("TempServiceImpl")
public class TempServiceImpl implements TempService {

	@Autowired
	TempRepository tempRepository;

	@Override
	public TempTable insertIntoTemp(TempTable tempTable) {
		TempTable tmpTbl = tempRepository.save(tempTable);
		return tmpTbl;
	}

	@Override
	public TempTable getOneData(int id) {
		TempTable tempTable = null;
		try {
			tempTable = tempRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	@Override
	public TempTable deleteOneData(int id) {
		TempTable tempTable = null;
		if (tempRepository.findOne(id) != null) {
			tempTable = new TempTable();
			tempRepository.delete(id);
		}
		return tempTable;
	}

	@Override
	public List<TempTable> retriveAllUsers() {
		return tempRepository.findAll();
	}
}