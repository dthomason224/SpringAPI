package com.example.spring_project.services.impl;

import com.example.spring_project.exceptions.InformationExistsException;
import com.example.spring_project.exceptions.InformationNotFoundException;
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
    public UserProfile createUserProfile(UserProfile userProfile) {
        UserProfile possibleUserProfile = userProfileRepository.findUserProfileById(userProfile.getId());

        if (possibleUserProfile != null) {
            throw new InformationExistsException("User profile exists");
        }
        else {
            return userProfileRepository.save(userProfile);
        }
    }

    @Override
    public UserProfile updateUserProfile(Long id, UserProfile userProfile) {
        UserProfile possibleUserProfile = userProfileRepository.findUserProfileById(id);

        if (possibleUserProfile == null) {
            throw new InformationNotFoundException("User profile does not exist");
        }
        else {
            possibleUserProfile.setFirstName(userProfile.getFirstName());
            possibleUserProfile.setLastName(userProfile.getLastName());
            return userProfileRepository.save(possibleUserProfile);
        }
    }

    @Override
    public void deleteUserProfile(Long id) {
        UserProfile possibleUserProfile = userProfileRepository.findUserProfileById(id);

        if (possibleUserProfile == null) {
            throw new InformationNotFoundException("User profile does not exist");
        }
        else {
            userProfileRepository.deleteById(id);
        }
    }

    @Override
    public UserProfile getUserProfile(Long id) {
        UserProfile userProfile = userProfileRepository.findUserProfileById(id);

        if (userProfile == null) {
            throw new InformationNotFoundException("User profile id of  " + id + "not found.");
        } else {
            return userProfile;
        }
    }
}
