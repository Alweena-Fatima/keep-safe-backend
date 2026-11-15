package com.keepsafe.backend.mapper;


import org.springframework.stereotype.Component;

import com.keepsafe.backend.dto.request.RegisterRequest;
import com.keepsafe.backend.dto.response.RegisterResponse;
import com.keepsafe.backend.entity.User;

//now we have RegisterRequest — receives registration details.
//RegisterResponse — returns safe user details.
//we need a way to convert between these DTOs and our User entity.
//RegisterRequest → User Entity → RegisterResponse we need two conversion

@Component 
public class UserMapper {
    //converts RegisterRequest to User entity
//Because hashing is not the mapper's responsibility.
//  AuthService will use BCrypt to hash the password before 
// passing it to the mapper.
    public User toEntity(RegisterRequest request, String hashedPassword) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPasswordHash(hashedPassword);
        return user;
    }

    //convert the User entity to RegisterResponse
    public RegisterResponse toResponse(User savedUser) {
        RegisterResponse response = new RegisterResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        return response;

    }
}
