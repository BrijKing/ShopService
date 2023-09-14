package com.example.shop_service.model;

import java.time.LocalDate;

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
public class Product {

    @Id
    private String id;
    private String title;
    private String description;
    private int quantity;
    private LocalDate maintenance;
    private boolean isMaintained;
    private long price;
    private byte[] image;

}
