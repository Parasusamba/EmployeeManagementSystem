package com.cognizant.EmployeeManagementSystem.exception;

import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;

@ControllerAdvice
public class EmployeeExceptionHandler {
	@ExceptionHandler(value = {EmployeeNotFoundException.class})
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException) {
		EmployeeException employeeException = new EmployeeException(
				employeeNotFoundException.getMessage(), employeeNotFoundException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(employeeException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception) {
		String errors = exception.getBindingResult()
				        .getFieldErrors().stream()
				        .map(e -> e.getField() +" : "+e.getDefaultMessage())
				        .collect(Collectors.joining(","));
		EmployeeException employeeException = new EmployeeException(errors, exception.getCause(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(employeeException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {HttpMessageNotReadableException.class})
	public ResponseEntity<Object> handleNotReadableException(HttpMessageNotReadableException exception) {
		EmployeeException employeeException = new EmployeeException(exception.getMessage(), exception.getCause(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(employeeException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class) 
	public ResponseEntity<Object> methodNotAllowedException(HttpRequestMethodNotSupportedException exception) {
       
		EmployeeException employeeException = new EmployeeException(exception.getMessage(), exception.getCause(), HttpStatus.METHOD_NOT_ALLOWED);
		return new ResponseEntity<Object>(employeeException, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<Object> handleAllException(Exception exception) {
		EmployeeException employeeException = new EmployeeException(exception.getLocalizedMessage(), exception.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Object>(employeeException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DataAccessException.class) 
	public ResponseEntity<Object> handleDataException(DataAccessException exception) {
		EmployeeException employeeException = new EmployeeException(exception.getMessage(), null, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(employeeException, HttpStatus.BAD_REQUEST);
	}
	
	
}
 
