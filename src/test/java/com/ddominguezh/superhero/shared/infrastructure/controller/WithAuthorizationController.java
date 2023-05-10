package com.ddominguezh.superhero.shared.infrastructure.controller;

import java.util.Base64;
import java.util.UUID;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class WithAuthorizationController {

	private static String BEARER = "Bearer ";
	private static String VALID_TOKEN = "123a4df8-b069-11ed-afa1-0242ac120002";
	
	//Once per test class
	private static final MySQLContainer mysql;
	 
    static {
        mysql = new MySQLContainer("mysql:latest");
        mysql.start();
        System.setProperty("spring.datasource.driver", mysql.getDriverClassName());
        System.setProperty("spring.datasource.url", mysql.getJdbcUrl());
        System.setProperty("spring.datasource.user", mysql.getUsername());
        System.setProperty("spring.datasource.password", mysql.getPassword());
        System.setProperty("spring.datasource.name", mysql.getDatabaseName());
    }
		
	public String authorizedToken() {
		return BEARER + Base64.getEncoder().encodeToString(VALID_TOKEN.getBytes());
	}
	
	public String unauthorizedToken() {
		return BEARER + Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
	}
}
