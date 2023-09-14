package com.example.shop_service.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto {

	private String id;
	private String title;
	private String description;
	private int quantity;
	private LocalDate maintenance;
	private boolean isMaintained;
	private long price;
	private MultipartFile image;
}
