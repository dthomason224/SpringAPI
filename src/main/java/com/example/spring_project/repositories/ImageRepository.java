package com.example.spring_project.repositories;

import com.example.spring_project.models.Image;
import com.example.spring_project.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAll();

    Image findImageById(Long id);

    void deleteById(Long id);
}
