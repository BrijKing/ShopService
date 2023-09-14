package com.example.shop_service.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDto {

	private String productId;
	private String title;
	private String description;
	private int quantity;
	private LocalDate maintenance;
	private boolean isMaintained;
	private long price;
	private byte[] image;

}
