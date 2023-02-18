package com.ddominguezh.superhero.shared.domain;

public abstract class DomainError extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2484794718351128662L;
	private final String errorCode;
    private final String errorMessage;

    public DomainError(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode    = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }
}