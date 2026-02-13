package com.example.RoleBased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	User getUser(String name) {
		return repo.findByName(name);
	}
	
}
