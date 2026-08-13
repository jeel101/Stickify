package com.eazybytes.eazystore.service;

import com.eazybytes.eazystore.dto.ContactRequestDto;
import com.eazybytes.eazystore.dto.ContactResponseDto;
import com.eazybytes.eazystore.dto.OrderRequestDto;
import com.eazybytes.eazystore.dto.OrderResponseDto;
import com.eazybytes.eazystore.entity.Contact;
import com.eazybytes.eazystore.entity.Order;

import java.util.List;

public interface IOrderService {
    void createOrder(OrderRequestDto orderRequest);

    List<OrderResponseDto> getOrder();
    List<OrderResponseDto> getAdminOrder();
    void updateOrderStatus(Long orderId, String orderStatus);
    List<ContactResponseDto> getMessages();
    Contact updateMessage(Long contactId, String status);
}
