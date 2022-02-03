package com.example.spring_project.services.impl;

import com.example.spring_project.models.Image;
import com.example.spring_project.services.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public Image createImage(Long id, @RequestBody Image image) {
        return null;
    }

    @Override
    public Image updateImage(Long id, Image image) {
        return null;
    }

    @Override
    public void deleteImage(Long id) {

    }

    @Override
    public List<Image> getImages() {
        return null;
    }
}
