package com.eazybytes.eazystore.repository;

import com.eazybytes.eazystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   //optional
// T -> Which Entity class this repo will manage(product)
// ID -> Type of Primary Key of that Entity (Long)
public interface ProductRepository extends JpaRepository<Product, Long> {
}
