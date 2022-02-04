package com.example.spring_project.services.impl;

import com.example.spring_project.models.Tag;
import com.example.spring_project.models.UserProfile;
import com.example.spring_project.repositories.UserProfileRepository;
import com.example.spring_project.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private UserProfileRepository userProfileRepository;

    @Autowired
    public void setUserProfileRepository(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public Tag createUserProfile(UserProfile userProfile) {
        return null;
    }

    @Override
    public Tag updateProfile(Long id, UserProfile userProfile) {
        return null;
    }

    @Override
    public void deleteUserProfile(Long id) {

    }

    @Override
    public Tag getUserProfile(Long id) {
        return null;
    }
}
