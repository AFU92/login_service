package com.dasetova.login_service.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dasetova.login_service.model.api.ErrorMessage;
import com.dasetova.login_service.model.exceptions.NotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private final static String BAD_REQUEST_MESSAGE = "The request message is invalid";
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<ErrorMessage> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		ex.getConstraintViolations().forEach((ConstraintViolation<?> violation) -> errors
				.add(violation.getPropertyPath() + ": " + violation.getMessage()));
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(BAD_REQUEST_MESSAGE, errors), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<ErrorMessage> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(BAD_REQUEST_MESSAGE, 
				Arrays.asList(ex.getCause().getCause().getMessage())),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<ErrorMessage> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(BAD_REQUEST_MESSAGE, 
				Arrays.asList(ex.getMessage())),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<ErrorMessage> handleNotFound(NotFoundException ex, WebRequest request) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
	}

}
