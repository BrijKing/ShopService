package com.example.shop_service.custom_exceptions;

public class OrderNotFoundException extends Exception {

	public OrderNotFoundException() {

		super("Order not found");
	}

}
