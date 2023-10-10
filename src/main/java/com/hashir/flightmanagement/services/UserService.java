package com.hashir.flightmanagement.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashir.flightmanagement.entities.User;
import com.hashir.flightmanagement.exceptions.UserNotFoundException;
import com.hashir.flightmanagement.repos.UserRepository;

@Service
public class UserService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		user=userRepository.save(user);
		LOGGER.info("User Registered Successfully with user id: "+user.getUserId());
		return user;
	}
	
	public User userLogin(String userId, String password) throws UserNotFoundException {
		User user= userRepository.findById(userId).orElse(null);
		if(user==null) {
			LOGGER.error("Invalid User Id");
			throw new UserNotFoundException("Invalid User Id");
		}
		else {
			String pass= user.getPassword();
			if(!(password.equals(pass))) {
				LOGGER.error("Invalid Password");
				throw new UserNotFoundException("Invalid Password ");
			}
		}
		
		LOGGER.info("User: "+user);
		
		return user;
	}
	
	public User getUser(String userId) throws UserNotFoundException {
		User user= userRepository.findById(userId).orElse(null);
		if(user==null) {
			LOGGER.error("Invalid User Id");
			throw new UserNotFoundException("Invalid User Id");
		}
		LOGGER.info("User: "+user);

		return user;
	}
	
	
	

}
