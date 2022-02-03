package com.example.spring_project.repositories;

import com.example.spring_project.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAll();

    Image findImageByIdAndImageTags(Long id);

    Image findImageById(Long id);

    void deleteImageById(Long id);
}
