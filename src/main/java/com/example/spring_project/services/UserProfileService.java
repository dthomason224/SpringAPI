package com.example.spring_project.services;

import com.example.spring_project.models.UserProfile;

public interface UserProfileService {
    UserProfile createUserProfile(UserProfile userProfile);
    UserProfile updateUserProfile(Long id, UserProfile userProfile);
    void deleteUserProfile(Long id);
    UserProfile getUserProfile(Long id);
}
