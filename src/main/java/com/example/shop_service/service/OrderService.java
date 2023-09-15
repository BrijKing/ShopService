package com.example.shop_service.service;

import java.util.List;

import com.example.shop_service.custom_exceptions.OrderNotFoundException;
import com.example.shop_service.custom_exceptions.ProductNotFoundException;
import com.example.shop_service.dto.OrderDto;

public interface OrderService {
    
    OrderDto createOrder(OrderDto orderDto) throws ProductNotFoundException;

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(String id) throws OrderNotFoundException;

    OrderDto updateOrder(OrderDto orderDto) throws OrderNotFoundException;

    void deleteOrder(String id);
}
