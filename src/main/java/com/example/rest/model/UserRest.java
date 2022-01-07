package com.example.rest.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRest {

	@NotBlank(message = "First name cannot be blank")
	private String firstname;
	
	@NotBlank(message = "Last name cannot be blank")
	private String lastname;
	
	@NotBlank(message = "Email cannot be blank")
	@Email
	private String email;
	
	private String userId;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
