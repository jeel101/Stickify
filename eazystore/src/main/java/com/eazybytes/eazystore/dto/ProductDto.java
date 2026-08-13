package com.eazybytes.eazystore.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

//Data Transfer Object
//It’s usually a simple class used to transfer data between layers - Controller ↔ Service
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer popularity;
    private String imageUrl;
    private Instant createdAt;
}
