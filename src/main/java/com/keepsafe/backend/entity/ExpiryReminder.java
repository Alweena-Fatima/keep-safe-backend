package com.keepsafe.backend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;
@Setter 
@Getter 
@Entity
@Table(name = "expiry_reminders")
public class ExpiryReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // many remainder can belong to one expiry record to many to one with expiry
    // record table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expiry_record_id", nullable = false)
    private ExpiryRecord expiryRecord;

    @Column(name = "reminder_days", nullable = false)
    private Integer reminderDays;
    // An expriy remainder can have multiple notifications to be sent to the user
    @OneToMany(mappedBy = "expiryReminder")
    private List<Notification> notifications = new ArrayList<>();
}
