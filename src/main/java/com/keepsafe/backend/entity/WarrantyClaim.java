
package com.keepsafe.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claims")
public class WarrantyClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Many warranty claims can belong to one warranty, so from the warranty claim's perspective, the relationship is @ManyToOne.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warranty_id", nullable = false)
    private Warranty warranty;

    @Column(name = "issue_description", nullable = false, columnDefinition = "TEXT")
    private String issueDescription;

    @Column(nullable = false, length = 30)
    private String status = "SUBMITTED";

    @Column(name = "claim_date", nullable = false)
    private LocalDate claimDate;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    @Column(name = "service_center", length = 255)
    private String serviceCenter;

    @Column(name = "claim_reference", length = 100)
    private String claimReference;
}
