package com.example.rest.util;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	public String generateRandomId() {
		return UUID.randomUUID().toString();
	}
}
