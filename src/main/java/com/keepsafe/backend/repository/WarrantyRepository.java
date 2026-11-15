package com.keepsafe.backend.repository;

import com.keepsafe.backend.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

// This repository handles database operations for warranties.
// JpaRepository provides save(), findById(), findAll(), and deleteById(),
// so we don't have to write these methods ourselves.
public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
}
