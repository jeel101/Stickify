package com.eazybytes.eazystore.dto;

import java.math.BigDecimal;

public record OrderItemResponseDto(String name, Integer quantity, BigDecimal price, String imageUrl) {
}
