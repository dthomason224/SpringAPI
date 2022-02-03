package com.example.spring_project.controllers;

import com.example.spring_project.models.requests.LoginRequest;
import com.example.spring_project.models.requests.RegisterRequest;
import com.example.spring_project.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth/users")
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register/")
    public ResponseEntity<?> createUser(@RequestBody RegisterRequest registerRequest) {
        System.out.println("created");
        return userService.registerUser(registerRequest);
    }

    @PostMapping("/login/")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("logging in");
        return userService.loginUser(loginRequest);
    }
}
