package com.example.spring_project.services;

import com.example.spring_project.models.Image;

import java.util.List;

public interface ImageService {
    public abstract void createImage(Image image);
    public abstract void updateImage(Long id, Image image);
    public abstract void deleteImage(Long id);
    public abstract List<Image> getImages();
}
