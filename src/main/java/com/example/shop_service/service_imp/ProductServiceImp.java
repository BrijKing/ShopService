package com.example.shop_service.service_imp;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.shop_service.custom_exceptions.ProductNotFoundException;
import com.example.shop_service.dto.ProductDto;
import com.example.shop_service.model.Product;
import com.example.shop_service.repository.ProductRepo;
import com.example.shop_service.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product addProductWithImage(ProductDto productDto) throws IOException {
		
		Product product = Product.builder()
			.id(productDto.getId())
			.title(productDto.getTitle())
			.description(productDto.getDescription())
			.maintenance(productDto.getMaintenance())
			.isMaintained(productDto.isMaintained())
			.price(productDto.getPrice())
			.quantity(productDto.getQuantity())
			.image(productDto.getImage().getBytes())
			.build();
		
		return productRepo.save(product);
	}

	@Override
	public List<ProductDto> getAllProducts() {

		List<Product> findAll = productRepo.findAll();

		return (List<ProductDto>) modelMapper.map(findAll, ProductDto.class);
	}
//
//	@Override
//	public ProductDto getProduct(String id) throws ProductNotFoundException {
//
//		Product product = productRepo.findById(id).orElseThrow(ProductNotFoundException::new);
//		return modelMapper.map(product, ProductDto.class);
//	}
//
//	@Override
//	public ProductDto updateProduct(ProductDto product) {
//
//		Product map = modelMapper.map(product, Product.class);
//		productRepo.save(map);
//		return modelMapper.map(map, ProductDto.class);
//	}

	@Override
	public void deleteProduct(String id) {

		productRepo.deleteById(id);
	}

}
