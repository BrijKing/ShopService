package com.example.shop_service.service_imp;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop_service.custom_exceptions.ProductNotFoundException;
import com.example.shop_service.dto.ProductDto;
import com.example.shop_service.dto.ResponseProductDto;
import com.example.shop_service.model.Product;
import com.example.shop_service.repository.ProductRepo;
import com.example.shop_service.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseProductDto addProductWithImage(ProductDto productDto) throws IOException {

		Product product = Product.builder().id(productDto.getId()).title(productDto.getTitle())
				.description(productDto.getDescription()).maintenance(productDto.getMaintenance())
				.isMaintained(productDto.isMaintained()).price(productDto.getPrice()).quantity(productDto.getQuantity())
				.image(productDto.getImage().getBytes()).build();

		Product savedProduct = productRepo.save(product);
		return modelMapper.map(savedProduct, ResponseProductDto.class);
	}

	@Override
	public List<ResponseProductDto> getAllProducts() {

		List<Product> productList = productRepo.findAll();
		return productList.stream().map((Product product) -> modelMapper.map(product, ResponseProductDto.class))
				.toList();
	}

	@Override
	public ResponseProductDto getProduct(String id) throws ProductNotFoundException {

		Product product = productRepo.findById(id).orElseThrow(ProductNotFoundException::new);
		return modelMapper.map(product, ResponseProductDto.class);
	}

	@Override
	public ResponseProductDto updateProduct(ProductDto productDto) throws IOException, ProductNotFoundException {

		Product existingProduct = productRepo.findById(productDto.getId()).orElseThrow(ProductNotFoundException::new);

		existingProduct.setTitle(productDto.getTitle());
		existingProduct.setDescription(productDto.getDescription());
		existingProduct.setMaintenance(productDto.getMaintenance());
		existingProduct.setMaintained(productDto.isMaintained());
		existingProduct.setPrice(productDto.getPrice());
		existingProduct.setQuantity(productDto.getQuantity());

		if (productDto.getImage() != null) {
			existingProduct.setImage(productDto.getImage().getBytes());
		}

		Product updatedProduct = productRepo.save(existingProduct);
		return modelMapper.map(updatedProduct, ResponseProductDto.class);
	}

	@Override
	public void deleteProduct(String id) {

		productRepo.deleteById(id);
	}
}
