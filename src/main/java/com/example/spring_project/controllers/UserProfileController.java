package com.example.spring_project.controllers;

import com.example.spring_project.models.User;
import com.example.spring_project.models.UserProfile;
import com.example.spring_project.services.UserProfileService;
import com.example.spring_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/user")
public class UserProfileController {
    private UserProfileService userProfileService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserProfileService(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping(path = "/profile/")
    public UserProfile createProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createUserProfile(userProfile);
    }

    @DeleteMapping(path = "/profile/{userProfileId}/")
    public void deleteUserProfile(@PathVariable(value = "userProfileId") Long id) {
        userProfileService.deleteUserProfile(id);
    }

    @PutMapping(path = "/profile/{userProfileId}/")
    public UserProfile updateUserProfile(@PathVariable(value = "userProfileId") Long id, @RequestBody UserProfile userProfile) {
        return userProfileService.updateUserProfile(id, userProfile);
    }

    @GetMapping(path = "/profile/{userProfileId}/")
    public UserProfile getUserProfile(@PathVariable(value = "userProfileId") Long id) {
        return userProfileService.getUserProfile(id);
    }

    @PostMapping(path = "/{userId}/profile/{profileId}/")
    public User createProfile(@PathVariable(value = "userId") Long id,
                              @PathVariable(value = "profileId") Long userProfileId) {
        return userService.addProfileToUser(id, userProfileId);
    }
}
