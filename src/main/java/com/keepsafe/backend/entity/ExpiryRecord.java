package com.keepsafe.backend.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="expiry_records")
public class ExpiryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //one product can have many expiry records, so many to one with product table
    //Many expiry records can belong to one product, so from the expiry record's perspective, the relationship is @ManyToOne.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;
}
