package com.example.spring_project.services;

import com.example.spring_project.models.User;
import com.example.spring_project.models.requests.LoginRequest;
import com.example.spring_project.models.requests.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    User findUserByEmailAddress(String email);

    User findUserById(Long id);

    ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest);

    ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest);

    User addProfileToUser(Long userId, Long profileId);
}
