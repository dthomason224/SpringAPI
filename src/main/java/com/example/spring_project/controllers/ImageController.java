package com.example.spring_project.controllers;

import com.example.spring_project.models.Image;
import com.example.spring_project.services.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/images")
public class ImageController {
    private ImageServiceImpl imageService;

    @Autowired
    public void setImageService(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @PostMapping()
    public Image createImage(Long id, @RequestBody Image image) {
        return imageService.createImage(id, image);
    }

    @PutMapping()
    public Image updateImage(Long id, @RequestBody Image image) {
        return imageService.updateImage(id, image);
    }

    @DeleteMapping()
    public void deleteImage(Long id) {
        imageService.deleteImage(id);
    }

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getImages();
    }
}
