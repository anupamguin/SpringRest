package com.example.rest.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

	@NotBlank(message = "First name cannot be blank")
	@Size(min = 2,message ="First name must not be less than 2 Characters")
	private String firstname;

	@NotBlank(message = "Last name cannot be blank")
	@Size(min = 2,message ="Last name must not be less than 2 Characters")
	private String lastname;

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

}
