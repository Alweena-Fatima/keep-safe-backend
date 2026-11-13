package com.keepsafe.backend.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //multiple notifications can belong to one user, so many to one with user table
    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //multiple notification belongs to one expiry remainder
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expiry_reminder_id", nullable = false)
    private ExpiryReminder expiryReminder;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(name = "scheduled_at", nullable = false)
    private LocalDateTime scheduledAt;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    @Column(nullable = false, length = 20)
    private String status = "PENDING";

    @Column(name = "is_read", nullable = false)
    private Boolean isRead = false;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}
