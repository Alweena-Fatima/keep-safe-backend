package com.keepsafe.backend.repository;

import com.keepsafe.backend.entity.WarrantyClaim;
import org.springframework.data.jpa.repository.JpaRepository;

// This repository handles database operations for warranty claims.
// JpaRepository provides save(), findById(), findAll(), and deleteById(),
// so we don't have to write these methods ourselves.
public interface WarrantyClaimRepository extends JpaRepository<WarrantyClaim, Long> {
}
