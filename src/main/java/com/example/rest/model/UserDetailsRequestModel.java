package com.example.rest.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

	@NotBlank(message = "First name cannot be blank")
	@Size(min = 2, message = "First name must not be less than 2 Characters")
	private String firstname;

	@NotBlank(message = "Last name cannot be blank")
	@Size(min = 2, message = "Last name must not be less than 2 Characters")
	private String lastname;

	@NotBlank(message = "Email cannot be blank")
	@Email
	private String email;

	@NotBlank(message = "Password cannot be blank")
	@Size(min = 8, max = 16, message = "Password must be in between 8 to 16")
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
