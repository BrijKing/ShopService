package com.example.shop_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.shop_service.model.Product;

public interface ProductRepo extends MongoRepository<Product, String>{
    
}
