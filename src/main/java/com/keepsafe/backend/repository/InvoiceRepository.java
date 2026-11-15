package com.keepsafe.backend.repository;

import com.keepsafe.backend.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

// This repository handles database operations for invoices.
// JpaRepository provides save(), findById(), findAll(), and deleteById(),
// so we don't have to write these methods ourselves.
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
