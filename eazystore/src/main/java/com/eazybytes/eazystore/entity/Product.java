package com.eazybytes.eazystore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "POPULARITY", nullable = false)
    private Integer popularity;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "CREATED_AT", nullable = false)
    private Instant createdAt;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @ColumnDefault("NULL")
    @Column(name = "UPDATED_AT")
    private Instant updatedAt;

    @ColumnDefault("NULL")
    @Column(name = "UPDATED_BY")
    private String updatedBy;

}