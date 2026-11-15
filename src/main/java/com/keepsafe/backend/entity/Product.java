package com.keepsafe.backend.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //many product can belong to one user to many to one with user tabel
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(length = 100)
    private String brand;
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "purchase_price", precision = 10, scale = 2)
    private BigDecimal purchasePrice;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
    //now we can have our product entity know about the invoices, expiry records, and warranties associated with it. This is done by adding a one-to-many relationship in the Product entity for each of these entities.
//    Why mappedBy = "product"?
//
//            Because ExpiryRecord.java already has:
    @OneToMany(mappedBy = "product")
    private List<ExpiryRecord> expiryRecords = new ArrayList<>();

    @OneToOne(mappedBy = "product")
    private Warranty warranty;

    @OneToMany(mappedBy = "product")
    private List<Invoice> invoices = new ArrayList<>();

}
