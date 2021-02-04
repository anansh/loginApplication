package com.example.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.TempDetails;
import com.example.main.model.TempTable;
import com.example.main.repository.TempDetailsRepository;
import com.example.main.repository.TempRepository;
import com.example.main.service.TempService;

@Service("TempServiceImpl")
public class TempServiceImpl implements TempService {

	@Autowired
	TempRepository tempRepository;
	
	@Autowired
	TempDetailsRepository tempDetailsRepository;

	@Override
	public TempTable insertIntoTemp(TempTable tempTable) {
		TempTable tmpTbl = tempRepository.save(tempTable);
		TempDetails tmpDetails = new TempDetails();
		tmpDetails.setId(tmpTbl.getTemp_details_id());
		tmpDetails.setTempName("Test");
		tempDetailsRepository.save(tmpDetails);
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