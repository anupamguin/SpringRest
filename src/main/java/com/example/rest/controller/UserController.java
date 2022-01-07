package com.example.rest.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.UpdateUserDetailsRequestModel;
import com.example.rest.model.UserDetailsRequestModel;
import com.example.rest.model.UserRest;
import com.example.rest.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	Map<String,UserRest> users;
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		
//		String a=null;
//		a.length();
		
//		if(true) throw new UserServiceException("User exception came");
		
		return "Get users was called with page =" + page + " and limit= " + limit + " and sort: " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE,
												MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		if(users.containsKey(userId)){
			return new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE }
	   , consumes = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDetailsRequestModel userRest) {
		
		UserRest ur = userService.createUser(userRest);
		
		return new ResponseEntity<UserRest>(ur,HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{userId}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
	   , consumes = { MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel model){
		
		UserRest userDetails =users.get(userId);
		
		if(userDetails == null)
			return new ResponseEntity<String>("User Data not be found",HttpStatus.NO_CONTENT);
		
		userDetails.setFirstname(model.getFirstname());
		userDetails.setLastname(model.getLastname());
		
		users.put(userId, userDetails);
		return new ResponseEntity<UserRest>(userDetails,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
}
