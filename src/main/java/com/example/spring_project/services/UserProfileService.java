package com.example.spring_project.services;

import com.example.spring_project.models.Tag;
import com.example.spring_project.models.UserProfile;

import java.util.List;

public interface UserProfileService {
    Tag createUserProfile(UserProfile userProfile);
    Tag updateProfile(Long id, UserProfile userProfile);
    void deleteUserProfile(Long id);
    Tag getUserProfile(Long id);
}
