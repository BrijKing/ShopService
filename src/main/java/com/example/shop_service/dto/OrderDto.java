package com.example.shop_service.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.shop_service.model.Product;

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
public class OrderDto {
    
	private String id;
	private String orderBy;
	private String status;
	private String address;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private int totalPrice;
	private List<String> productsId;
}
