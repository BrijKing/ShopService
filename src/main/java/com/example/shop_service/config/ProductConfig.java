package com.example.shop_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
