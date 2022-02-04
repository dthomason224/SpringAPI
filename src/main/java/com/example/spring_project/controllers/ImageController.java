package com.example.spring_project.controllers;

import com.example.spring_project.models.Image;
import com.example.spring_project.services.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ImageController {
    private ImageServiceImpl imageService;

    @Autowired
    public void setImageService(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @PostMapping(path = "/images/")
    public Image createImage(Long id, @RequestBody Image image) {
        return imageService.createImage(id, image);
    }

    @PostMapping(path = "/images/{imageId}/tags/{tagId}/")
    public void addTagToImage(@PathVariable(value = "imageId") Long id,
                             @PathVariable(value = "tagId") Long tagId) {
        imageService.addTagToImage(id, tagId);
    }

    @PutMapping(path = "/images/{imageId}/")
    public Image updateImage(@PathVariable(value = "imageId") Long id, @RequestBody Image image) {
        return imageService.updateImage(id, image);
    }

    @DeleteMapping(path = "/images/{imageId}/")
    public void deleteImage(@PathVariable(value = "imageId") Long id) {
        imageService.deleteImage(id);
    }

    @GetMapping(path = "/images/{imageId}/")
    public Image getImage(@PathVariable(value = "imageId") Long id) {
        return imageService.getImage(id);
    }

    @GetMapping(path = "/images/")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @PostMapping(path = "/user/{userId}/image/{imageId}/")
    public Image addUserToUser(@PathVariable(value = "imageId") Long id,
                              @PathVariable(value = "userId") Long userId) {
        return imageService.addUserToImage(id, userId);
    }
}
