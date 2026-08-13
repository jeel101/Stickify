package com.eazybytes.eazystore.service.impl;

import com.eazybytes.eazystore.constants.ApplicationConstants;
import com.eazybytes.eazystore.dto.*;
import com.eazybytes.eazystore.entity.*;
import com.eazybytes.eazystore.exception.ResourceNotFoundException;
import com.eazybytes.eazystore.repository.ContactRepository;
import com.eazybytes.eazystore.repository.OrderRepository;
import com.eazybytes.eazystore.repository.ProductRepository;
import com.eazybytes.eazystore.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ProfileServiceImpl profileService;
    private final ContactRepository contactRepository;
    private final ContactServiceImpl contactService;

    @Override
    public void createOrder(OrderRequestDto orderRequest) {
        Customer customer = profileService.getAuthenticatedCustomer();
//        create order
        Order order = new Order();
        order.setCustomer(customer);
        BeanUtils.copyProperties(orderRequest, order);
        order.setOrderStatus((ApplicationConstants.ORDER_STATUS_CREATED));
//        Map order items
        List<OrderItem> orderItems = orderRequest.items().stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            Product product = productRepository.findById(Long.valueOf(item.productId()))  //changes here
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "ProductID",
                            item.productId().toString()));
            orderItem.setProduct(product);
            orderItem.setQuantity(item.quantity());
            orderItem.setPrice(item.price());
            return orderItem;
        }).collect(Collectors.toList());
        order.setOrderItems(orderItems);
        orderRepository.save(order);
    }

    @Override
    public List<OrderResponseDto> getOrder() {
        Customer customer = profileService.getAuthenticatedCustomer();
        List<Order> orders =  orderRepository.findByCustomerCustomerIdOrderByCreatedAt(customer.getCustomerId());
        List<OrderResponseDto> orderList = orders.stream().map(order -> tranformToOrderResponseDto(order)).toList();
        return orderList;
    }

    @Override
    public List<OrderResponseDto> getAdminOrder() {
        List<Order> orders = orderRepository.findByOrderStatus(ApplicationConstants.ORDER_STATUS_CREATED);
        return orders.stream().map(this::tranformToOrderResponseDto).toList();
    }

    @Override
    public void updateOrderStatus(Long orderId, String orderStatus) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        orderRepository.updateOrderStatus(orderId, orderStatus, email);
    }

    @Override
    public List<ContactResponseDto> getMessages() {
        List<Contact> msg = contactRepository.fetchByStatus(ApplicationConstants.CONTACT_STATUS_OPEN);
        return msg.stream().map(msgs -> contactService.tranformToDto(msgs)).toList();
    }

    @Override
    public Contact updateMessage(Long contactId, String status) {
        Contact contact = contactRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Contact", "ContactId", contactId.toString())
        );
        contact.setStatus(status);
        contactRepository.save(contact);
        return contact;
    }

    private OrderResponseDto tranformToOrderResponseDto(Order order) {
        List<OrderItemResponseDto> items =  order.getOrderItems().stream().map(item -> new OrderItemResponseDto(
                item.getProduct().getName(),
                item.getQuantity(),
                item.getPrice(),
                item.getProduct().getImageUrl()
        )).toList();

        return new OrderResponseDto(
                items,
                order.getTotalPrice(),
                order.getOrderStatus(),
                order.getOrderId(),
                order.getCreatedAt()
        );
    }
}
