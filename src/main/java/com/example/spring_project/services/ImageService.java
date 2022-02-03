package com.example.spring_project.services;

import com.example.spring_project.models.Image;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ImageService {
    Image createImage(Long id, @RequestBody Image image);
    Image updateImage(Long id, Image image);
    void deleteImage(Long id);
    List<Image> getImages();
}
