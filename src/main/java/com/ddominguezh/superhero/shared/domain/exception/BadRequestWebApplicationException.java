package com.ddominguezh.superhero.shared.domain.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class BadRequestWebApplicationException extends CustomWebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 737683086046855797L;
	private static Integer STATUS_CODE = 590;
	public BadRequestWebApplicationException(String message){
		 super(Response.status(STATUS_CODE).entity(message).type(MediaType.APPLICATION_JSON_TYPE).build());
	}
	@Override
	public Integer getStatusCode() {
		return STATUS_CODE;
	}
}
