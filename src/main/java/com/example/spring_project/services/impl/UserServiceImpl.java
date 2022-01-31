package com.example.spring_project.services.impl;

import com.example.spring_project.models.User;
import com.example.spring_project.repositories.UserRepository;
import com.example.spring_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByEmailAddress(String email) {
        return userRepository.findByEmailAddress(email);
    }
}
