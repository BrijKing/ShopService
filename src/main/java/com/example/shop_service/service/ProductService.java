package com.example.shop_service.service;

import java.io.IOException;
import java.util.List;

import com.example.shop_service.custom_exceptions.ProductNotFoundException;
import com.example.shop_service.dto.ProductDto;
import com.example.shop_service.dto.ResponseProductDto;

public interface ProductService {

	ResponseProductDto addProductWithImage(ProductDto product) throws IOException;

	List<ResponseProductDto> getAllProducts();
	
	ResponseProductDto getProduct(String id) throws ProductNotFoundException;

	ResponseProductDto updateProduct(ProductDto product) throws IOException, ProductNotFoundException;

	void deleteProduct(String id);
}
