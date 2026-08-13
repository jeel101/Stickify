package com.eazybytes.eazystore.controller;

import com.eazybytes.eazystore.constants.ApplicationConstants;
import com.eazybytes.eazystore.dto.ContactRequestDto;
import com.eazybytes.eazystore.dto.ContactResponseDto;
import com.eazybytes.eazystore.dto.OrderResponseDto;
import com.eazybytes.eazystore.dto.ResponseDto;
import com.eazybytes.eazystore.entity.Contact;
import com.eazybytes.eazystore.entity.Order;
import com.eazybytes.eazystore.service.IContactService;
import com.eazybytes.eazystore.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final IOrderService iOrderService;
    private final IContactService iContactService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getAdminOrders(Order order) {
        return ResponseEntity.ok().body(iOrderService.getAdminOrder());
    }

    @PatchMapping("/orders/{orderId}/confirm")
    public ResponseEntity<ResponseDto> confirmOrder(@PathVariable Long orderId) {
        iOrderService.updateOrderStatus(orderId, ApplicationConstants.ORDER_STATUS_CONFIRMED);
        return ResponseEntity.ok(
                new ResponseDto("200", "Order #" + orderId + "has been approved")
        );
    }

    @PatchMapping("/orders/{orderId}/cancel")
    public ResponseEntity<ResponseDto> cancelOrder(@PathVariable Long orderId) {
        iOrderService.updateOrderStatus(orderId, ApplicationConstants.ORDER_STATUS_CANCELLED);
        return ResponseEntity.ok(
                new ResponseDto("200", "Order #" + orderId + "has been cancelled")
        );
    }

    @GetMapping("/messages")
    public ResponseEntity<List<ContactResponseDto>> getMessages() {
        return ResponseEntity.ok().body(iOrderService.getMessages());
    }

    @PatchMapping("/messages/{contactId}/close")
    public ResponseEntity<ResponseDto> updateMsg(@PathVariable Long contactId) {
         Contact updatedContact = iOrderService.updateMessage(contactId, ApplicationConstants.CONTACT_STATUS_CLOSE);
        return ResponseEntity.ok(
                new ResponseDto("200", "Contact #" + updatedContact.getId() + "has been closed")
        );
    }
}
