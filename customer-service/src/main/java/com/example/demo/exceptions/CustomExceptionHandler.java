package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class CustomExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public ErrorHandler  handleAllException(Exception ex, WebRequest req) {
		
		return new ErrorHandler(ex.getMessage(), req.getDescription(false),LocalDateTime.now());
	}
	
	@ExceptionHandler(ElementNotFoundException.class)
	public ErrorHandler handleElementNotFound(Exception ex, WebRequest req) {
		
		return new ErrorHandler("ERR-20001"+ex.getMessage(), req.getDescription(false),LocalDateTime.now());

	}
}
