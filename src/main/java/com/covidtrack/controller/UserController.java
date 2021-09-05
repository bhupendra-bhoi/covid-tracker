package com.covidtrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidtrack.exception.UserNotCreatedException;
import com.covidtrack.exception.UserNotFoundException;
import com.covidtrack.model.SelfAssessment;
import com.covidtrack.model.User;
import com.covidtrack.model.response.UserResponse;
import com.covidtrack.service.SelfAssessmentService;
import com.covidtrack.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SelfAssessmentService selfAssessmentService;
	
	@PostMapping
	public ResponseEntity<UserResponse> registerUser(@RequestBody User user){
		UserResponse response = userService.registeruser(user);
		if(response == null) {
			throw new UserNotCreatedException();
		}
		return new ResponseEntity<UserResponse>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<User> getUserWithId(@PathVariable Integer userId){
		User user = userService.getUserWithId(userId);
		if(user == null)
			throw new UserNotFoundException();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("selfAssessment")
	public ResponseEntity<UserResponse> selfAssessment(@RequestBody SelfAssessment selfAssessment){
		UserResponse response = selfAssessmentService.assessSymptopms(selfAssessment);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
}
