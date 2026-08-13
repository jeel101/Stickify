package com.eazybytes.eazystore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "contacts")

@NamedQuery(name = "Contact.fetchByStatus",
    query = "select c from Contact c where c.status=:status")

@NamedNativeQuery(name = "Contact.findByStatusUsingNative",
    query = "select c from contacts c where c.status=:status",
    resultClass = Contact.class)

public class Contact extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "mobile_number", nullable = false, length = 15)
    private String mobileNumber;

    @Column(name = "message", nullable = false, length = 500)
    private String message;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

}
