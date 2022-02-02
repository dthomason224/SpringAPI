package com.example.spring_project.services.impl;

import com.example.spring_project.models.User;
import com.example.spring_project.models.requests.RegisterRequest;
import com.example.spring_project.repositories.UserRepository;
import com.example.spring_project.services.UserService;
import com.example.spring_project.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils){
        this.jwtUtils = jwtUtils;
    }

    @Override
    public User findUserByEmailAddress(String email) {
        return userRepository.findUserByEmailAddress(email);
    }

    @Override
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        if (userRepository.existsByEmailAddress(registerRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body("user exists already");
        }

        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setEmailAddress(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreatedAt(registerRequest.getCreatedAt());

        userRepository.save(user);

        return ResponseEntity.ok("User created");
    }
}
