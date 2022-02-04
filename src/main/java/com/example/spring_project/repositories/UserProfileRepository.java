package com.example.spring_project.repositories;

import com.example.spring_project.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findUserProfileById(Long id);

    void deleteById(Long id);
}
