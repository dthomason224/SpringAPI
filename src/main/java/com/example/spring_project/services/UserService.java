package com.example.spring_project.services;

import com.example.spring_project.models.User;

public interface UserService {
    public abstract User findUserByEmailAddress(String email);
}
