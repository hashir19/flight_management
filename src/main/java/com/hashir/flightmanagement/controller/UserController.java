package com.hashir.flightmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hashir.flightmanagement.entities.User;
import com.hashir.flightmanagement.exceptions.UserNotFoundException;
import com.hashir.flightmanagement.services.UserService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
	
	//private static final Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createuser")
		public User createUser(@RequestBody User user) {
			user= userService.createUser(user);	
			//logger.info("User created");
			return user;
	}
	
	@GetMapping("/userlogin/{userId}/{password}")
	public User userLogin(@PathVariable String userId, @PathVariable String password) throws UserNotFoundException {
		User user= userService.userLogin(userId, password);
		return user;
	}

}
