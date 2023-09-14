package com.example.shop_service.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

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
@Document
@Component
@Builder
public class Order {

    @Id
	private String id;
	private String orderBy;
	private String status;
	private String address;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private int totalPrice;
	private List<String> productsId;
}
