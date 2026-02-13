package com.example.RoleBased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/getResource")
	String acceptRequest(@RequestBody UserRequest req) {
		String name = req.username;
		String password = req.password;
		User user = service.getUser(name);
		
		if(user != null) {
			if(user.name.equals(name) && user.password.equals(password)) {
				if(user.role.equals("admin")) {
					return "admin";
				} else {
					return "user";
				}
			}
		}
		return "invalid";
	}
	
}
