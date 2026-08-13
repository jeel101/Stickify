package com.eazybytes.eazystore.repository;

import com.eazybytes.eazystore.entity.Customer;
import com.eazybytes.eazystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository   //optional
// T -> Which Entity class this repo will manage(product)
// ID -> Type of Primary Key of that Entity (Long)
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailOrMobileNumber(String email, String mobileNumber);
    Optional<Customer> findByEmail(String email);
}
