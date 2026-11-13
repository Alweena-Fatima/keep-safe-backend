
package com.keepsafe.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many invoices can belong to one product, so from the invoice's perspective, the relationship is @ManyToOne.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    @Column(name = "file_url", nullable = false, length = 500)
    private String fileUrl;

    @Column(name = "file_hash", length = 64)
    private String fileHash;

    @Column(name = "uploaded_at", insertable = false, updatable = false)
    private LocalDateTime uploadedAt;
}
