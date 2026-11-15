package com.keepsafe.backend.repository;

import com.keepsafe.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email); //we need to check if a user with the same email already exists in the database. This method will be used in the registration process to prevent duplicate accounts.
}
