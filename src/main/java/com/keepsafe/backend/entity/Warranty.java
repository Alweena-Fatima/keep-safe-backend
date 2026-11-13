package com.keepsafe.backend.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranties")
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //One product can have at most one warranty.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "coverage_details", columnDefinition = "TEXT")
    private String coverageDetails;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
