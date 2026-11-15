package com.keepsafe.backend.repository;

import com.keepsafe.backend.entity.ExpiryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

// This repository handles database operations for expiry records.
// JpaRepository provides save(), findById(), findAll(), and deleteById(),
// so we don't have to write these methods ourselves.
public interface ExpiryRecordRepository extends JpaRepository<ExpiryRecord, Long> {
}
