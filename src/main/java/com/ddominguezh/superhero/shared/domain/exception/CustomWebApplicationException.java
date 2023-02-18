package com.ddominguezh.superhero.shared.domain.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public abstract class CustomWebApplicationException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3999506328428937178L;

	public CustomWebApplicationException(Response build) {
		super(build);
	}

	public abstract String getMessage();
	public abstract Integer getStatusCode();
	
	public boolean equals(String message){
		return getMessage().equals(message);
	}
	
}
