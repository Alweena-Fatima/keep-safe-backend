package com.keepsafe.backend.repository;

import com.keepsafe.backend.entity.ExpiryReminder;
import org.springframework.data.jpa.repository.JpaRepository;

// This repository handles database operations for expiry reminders.
// JpaRepository provides save(), findById(), findAll(), and deleteById(),
// so we don't have to write these methods ourselves.
public interface ExpiryReminderRepository extends JpaRepository<ExpiryReminder, Long> {
}
