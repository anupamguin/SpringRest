package com.example.rest.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.model.UserDetailsRequestModel;
import com.example.rest.model.UserRest;
import com.example.rest.service.UserService;
import com.example.rest.util.Utils;

@Service
public class UserServiceImpl implements UserService{

	Map<String,UserRest> users;
	Utils utils;
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils=utils;
	}
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userRest) {
		UserRest ur = new UserRest();
		ur.setFirstname(userRest.getFirstname());
		ur.setLastname(userRest.getLastname());
		ur.setEmail(userRest.getEmail());
		
		String userId = utils.generateRandomId();
		ur.setUserId(userId);
		
		if(users == null)  users=new HashMap<>();
		users.put(userId, ur);
		
		return ur;
	}

}
