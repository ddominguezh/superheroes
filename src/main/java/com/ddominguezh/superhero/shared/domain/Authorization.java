package com.ddominguezh.superhero.shared.domain;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.ddominguezh.superhero.shared.domain.exception.AuthorizationException;

public class Authorization {

	private static String BEARER = "Bearer ";
	private static String VALID_TOKEN = "123a4df8-b069-11ed-afa1-0242ac120002";
	private String token;
	public Authorization(String token) throws UnsupportedEncodingException {
		this.token = token;
		validate();
	}
	
	private void validate() throws UnsupportedEncodingException {
		try {
			token = token.substring(BEARER.length());
			if(!VALID_TOKEN.equals(new String(Base64.getDecoder().decode(token), "UTF-8"))) {
				throw new AuthorizationException();
			}
		}catch(Exception e) {
			throw new AuthorizationException();
		}
	}
}
