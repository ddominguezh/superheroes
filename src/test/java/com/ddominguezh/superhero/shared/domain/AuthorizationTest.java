package com.ddominguezh.superhero.shared.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

import org.junit.Test;

import com.ddominguezh.spring.core.shared.domain.Authorization;
import com.ddominguezh.spring.core.shared.domain.exception.AuthorizationException;

public class AuthorizationTest {

	@Test
	public void authorized() throws UnsupportedEncodingException {
		new Authorization("Bearer MTIzYTRkZjgtYjA2OS0xMWVkLWFmYTEtMDI0MmFjMTIwMDAy");
	}
	
	@Test
	public void unauthorized() {
		assertThrows(AuthorizationException.class, () -> new Authorization("Bearer " + Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes())));
	}
}
