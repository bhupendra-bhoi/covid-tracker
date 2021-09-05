package com.covidtrack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidtrack.model.User;
import com.covidtrack.model.response.UserResponse;
import com.covidtrack.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public UserResponse registeruser(User user) {
		userRepository.save(user);
		return new UserResponse("userId", user.getId());
	}
	public User getUserWithId(Integer userId) {
		return userRepository.getById(userId);
	}
}
