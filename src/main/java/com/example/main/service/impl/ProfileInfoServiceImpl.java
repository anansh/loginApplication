package com.example.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.ProfileInfo;
import com.example.main.repository.ProfileInfoRepository;
import com.example.main.service.ProfileInfoService;

@Service("profileInfoService")
public class ProfileInfoServiceImpl implements ProfileInfoService {

	@Autowired
	ProfileInfoRepository profileInRepo;

	@Override
	public ProfileInfo getProfileInfoById(int id) {
		return profileInRepo.getOne(id);
	}

}