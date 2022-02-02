package com.example.spring_project.repositories;

import com.example.spring_project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmailAddress(String email);

    Boolean existsByEmailAddress(String email);
}
