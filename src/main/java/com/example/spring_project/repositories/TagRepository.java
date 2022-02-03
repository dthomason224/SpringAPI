package com.example.spring_project.repositories;

import com.example.spring_project.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAll();

    Tag findByName(String name);

    Tag findTagById(Long id);

    Tag deleteTagById(Long id);
}
