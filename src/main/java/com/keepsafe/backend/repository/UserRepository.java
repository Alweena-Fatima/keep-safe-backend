package com.keepsafe.backend.repository;

import com.keepsafe.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// This repository handles database operations for users.
// JpaRepository provides save(), findById(), findAll(), and deleteById(),
// so we don't have to write these methods ourselves. Long is the user ID type.
public interface UserRepository extends JpaRepository<User, Long> {
}
