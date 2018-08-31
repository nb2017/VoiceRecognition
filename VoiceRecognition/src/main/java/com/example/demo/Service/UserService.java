package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Entity.User;
import com.example.demo.repository.userRepository;

@Service
public class UserService {
	@Autowired
	userRepository repository;

	public User search(Integer id) {
		User user = repository.findOne(id);
		return user;
	}

}
