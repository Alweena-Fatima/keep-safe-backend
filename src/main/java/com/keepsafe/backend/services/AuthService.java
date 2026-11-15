package com.keepsafe.backend.services;

import com.keepsafe.backend.dto.request.RegisterRequest;
import com.keepsafe.backend.dto.response.RegisterResponse;
import com.keepsafe.backend.entity.User;
import com.keepsafe.backend.mapper.UserMapper;
import com.keepsafe.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    // Handles registration of a new user.
    public RegisterResponse register(RegisterRequest request) {
        // Check if email exist 
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists.");
        }

        // Hash the password before storing it in the database.
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        User user = userMapper.toEntity(request, hashedPassword);

        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
}
