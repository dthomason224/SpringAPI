package com.example.spring_project.services;

import com.example.spring_project.models.Tag;
import com.example.spring_project.models.UserProfile;

import java.util.List;

public interface UserProfileService {
    UserProfile createUserProfile(UserProfile userProfile);
    UserProfile updateProfile(Long id, UserProfile userProfile);
    void deleteUserProfile(Long id);
    UserProfile getUserProfile(Long id);
}
