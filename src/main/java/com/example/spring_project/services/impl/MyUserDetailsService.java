package com.example.spring_project.services.impl;

import com.example.spring_project.exceptions.InformationNotFoundException;
import com.example.spring_project.models.User;
import com.example.spring_project.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmailAddress(email);
        if (user == null) {
            throw new InformationNotFoundException("Username doesn't exist");
        }
        return new MyUserDetails(user);
    }
}
