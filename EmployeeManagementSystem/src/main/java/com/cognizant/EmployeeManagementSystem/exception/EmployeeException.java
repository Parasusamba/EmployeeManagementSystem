package com.cognizant.EmployeeManagementSystem.exception;

import org.springframework.http.HttpStatus;

public class EmployeeException {
	private final String messgae;
	private final Throwable throwable;
	private final HttpStatus status;
	public EmployeeException(String messgae, Throwable throwable, HttpStatus status) {
		super();
		this.messgae = messgae;
		this.throwable = throwable;
		this.status = status;
	}
	public String getMessgae() {
		return messgae;
	}
	public Throwable getThrowable() {
		return throwable;
	}
	public HttpStatus getStatus() {
		return status;
	}
}
