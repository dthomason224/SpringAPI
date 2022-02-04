package com.example.spring_project.services;

import com.example.spring_project.models.Image;

import java.util.List;

public interface ImageService {
    Image createImage(Long id, Image image);
    void addTagToImage(Long id, Long tagId);
    Image updateImage(Long id, Image image);
    void deleteImage(Long id);
    Image getImage(Long id);
    List<Image> getAllImages();
}
