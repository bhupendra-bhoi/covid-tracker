package com.covidtrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidtrack.exception.UserNotCreatedException;
import com.covidtrack.exception.UserNotFoundException;
import com.covidtrack.model.Admin;
import com.covidtrack.model.CovidResult;
import com.covidtrack.model.response.UserResponse;
import com.covidtrack.service.AdminService;

@RestController
@RequestMapping("api/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	
	@PostMapping
	public ResponseEntity<UserResponse> registerUser(@RequestBody Admin admin){
		UserResponse response = adminService.registerAdmin(admin);
		if(response == null) {
			throw new UserNotCreatedException();
		}
		return new ResponseEntity<UserResponse>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Admin> getUserWithId(@PathVariable Integer id){
		Admin admin = adminService.getAdminWithId(id);
		if(admin == null)
			throw new UserNotFoundException();
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@PostMapping("updateCovidResult")
	public ResponseEntity<UserResponse> updateCovidResult(@RequestBody CovidResult covidResult){
		UserResponse response = adminService.updateCovidResult(covidResult);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
}
