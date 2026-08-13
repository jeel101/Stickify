package com.eazybytes.eazystore.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record OrderResponseDto(List<OrderItemResponseDto> items, BigDecimal totalPrice,
                               String orderStatus, Long orderId, Instant createdAt) {
}
