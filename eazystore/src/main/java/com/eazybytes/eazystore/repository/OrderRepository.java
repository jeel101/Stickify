package com.eazybytes.eazystore.repository;

import com.eazybytes.eazystore.entity.Contact;
import com.eazybytes.eazystore.entity.Customer;
import com.eazybytes.eazystore.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerCustomerIdOrderByCreatedAt(Long customerId);
    List<Order> findByOrderStatus(String orderStatus);

//    making our own custom query using JPQL
    @Query("SELECT o FROM Order o WHERE o.customer=:customer ORDER BY o.createdAt DESC")
    List<Order> findOrdersByCustomer(@Param("customer") Customer customer);

    @Query("SELECT o FROM Order o WHERE o.orderStatus=?1 ORDER BY o.createdAt DESC")
    List<Order> findOrderByStatus(String status);

    //    making our own custom query using Native Query
    @Query(value = "SELECT * FROM orders o WHERE o.customer_id=:customerId ORDER BY o.created_at DESC", nativeQuery = true)
    List<Order> findOrdersByCustomerUsingNative(@Param("customerId") Long customerId);

    @Query(value = "SELECT * FROM orders o WHERE o.order_status=?1 ORDER BY o.created_at DESC", nativeQuery = true)
    List<Order> findOrderByStatusUsingNative(String status);

    @Transactional
    @Modifying
    @Query("update Order o set o.orderStatus=:orderStatus, o.updatedAt=CURRENT_TIMESTAMP, o.updatedBy=:email where o.orderId=:orderId")
    int updateOrderStatus(@Param("orderId") Long orderId, @Param("orderStatus") String orderStatus, @Param("email") String email);
}
