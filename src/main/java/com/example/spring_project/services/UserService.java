package com.example.spring_project.services;

import com.example.spring_project.models.User;
import com.example.spring_project.models.requests.LoginRequest;
import com.example.spring_project.models.requests.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    public abstract User findUserByEmailAddress(String email);

    public abstract ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest);

    public abstract  ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest);
}
