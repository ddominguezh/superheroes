package com.ddominguezh.superhero.shared.infrastructure.controller;

import java.util.Base64;
import java.util.UUID;

public class WithAuthorizationController {

	private static String BEARER = "Bearer ";
	private static String VALID_TOKEN = "123a4df8-b069-11ed-afa1-0242ac120002";
	
	public String authorizedToken() {
		return BEARER + Base64.getEncoder().encodeToString(VALID_TOKEN.getBytes());
	}
	
	public String unauthorizedToken() {
		return BEARER + Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
	}
}
