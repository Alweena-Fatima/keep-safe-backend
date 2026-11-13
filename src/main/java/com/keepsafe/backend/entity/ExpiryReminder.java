package com.keepsafe.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name="expiry_reminders")
public class ExpiryReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //many remainder can belong to one expiry record to many to one with expiry record table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expiry_record_id", nullable = false)
    private ExpiryRecord expiryRecord;

    @Column(name="reminder_days", nullable = false)
    private Integer reminderDays;
}
