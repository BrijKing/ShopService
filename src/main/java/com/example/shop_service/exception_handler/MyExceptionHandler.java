package com.example.shop_service.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.shop_service.custom_exceptions.ProductNotFoundException;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFound(ProductNotFoundException c){
		return new ResponseEntity<>(c.getMessage(),HttpStatus.NOT_FOUND);
	}
}
