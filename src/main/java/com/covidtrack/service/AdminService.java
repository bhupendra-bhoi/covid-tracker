package com.covidtrack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidtrack.model.Admin;
import com.covidtrack.model.CovidResult;
import com.covidtrack.model.response.UserResponse;
import com.covidtrack.repository.AdminRepository;
import com.covidtrack.repository.CovidResultRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CovidResultRepository covidResultRepository;

	public UserResponse registerAdmin(Admin admin) {
		adminRepository.save(admin);
		return new UserResponse("adminId", admin.getId());
	}

	public Admin getAdminWithId(Integer userId) {
		return adminRepository.getById(userId);
	}
	
	public UserResponse updateCovidResult(CovidResult covidResult) {
		try{
			covidResultRepository.save(covidResult);
			return new UserResponse("updated",1);
		} catch(Exception e) {
			return new UserResponse("updated",0);
		}
	}

}
