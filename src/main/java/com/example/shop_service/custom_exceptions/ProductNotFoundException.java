package com.example.shop_service.custom_exceptions;

public class ProductNotFoundException extends Exception{
	
	public ProductNotFoundException() {
		
		super("Product not found");
	}

}
