package com.example.shop_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.shop_service.model.Order;

public interface OrderRepo extends MongoRepository<Order, String> {
    
}
