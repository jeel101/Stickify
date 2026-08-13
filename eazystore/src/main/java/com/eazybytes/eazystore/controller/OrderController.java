package com.eazybytes.eazystore.controller;

import com.eazybytes.eazystore.dto.OrderRequestDto;
import com.eazybytes.eazystore.dto.OrderResponseDto;
import com.eazybytes.eazystore.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final IOrderService iOrderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        iOrderService.createOrder(orderRequestDto);
        return ResponseEntity.ok("Order created successfully");
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getOrder() {
        List<OrderResponseDto> orderList = iOrderService.getOrder();
        return ResponseEntity.ok(orderList);
    }
}
