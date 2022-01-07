package com.example.rest.service;

import com.example.rest.model.UserDetailsRequestModel;
import com.example.rest.model.UserRest;

public interface UserService {

	UserRest createUser(UserDetailsRequestModel model);
}
