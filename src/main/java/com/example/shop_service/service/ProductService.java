package com.example.shop_service.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.shop_service.custom_exceptions.ProductNotFoundException;
import com.example.shop_service.dto.ProductDto;
import com.example.shop_service.model.Product;

public interface ProductService {

//	ProductDto addProduct(ProductDto product);

//	List<ProductDto> getAllProducts();
//	
//	ProductDto getProduct(String id) throws ProductNotFoundException;
//
//	ProductDto updateProduct(ProductDto product);

	void deleteProduct(String id);

	Product addProductWithImage(ProductDto product) throws IOException;

}
