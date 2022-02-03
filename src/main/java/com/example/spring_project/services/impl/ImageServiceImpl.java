package com.example.spring_project.services.impl;

import com.example.spring_project.exceptions.InformationExistsException;
import com.example.spring_project.exceptions.InformationNotFoundException;
import com.example.spring_project.models.Image;
import com.example.spring_project.models.Tag;
import com.example.spring_project.repositories.ImageRepository;
import com.example.spring_project.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    private ImageRepository imageRepository;

    @Autowired
    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image createImage(Long id, Image image) {
        Image possibleImage = imageRepository.findImageById(id);

        if (possibleImage != null) {
            throw new InformationExistsException("Image already exists");
        }

        possibleImage.setTitle(image.getTitle());
        possibleImage.setCreatedAt(image.getCreatedAt());
        possibleImage.setViews(image.getViews());

        return imageRepository.save(possibleImage);
    }

    @Override
    public Image updateImage(Long id, Image image) {
        Image possibleImage = imageRepository.findImageById(id);

        if (possibleImage == null) {
            throw new InformationNotFoundException("Image id of " + id + " does not exist");
        } else {
            possibleImage.setTitle(image.getTitle());
            possibleImage.setCreatedAt(image.getCreatedAt());
            possibleImage.setViews(image.getViews());

            return imageRepository.save(possibleImage);
        }
    }

    @Override
    public void deleteImage(Long id) {
        Image image = imageRepository.findImageById(id);

        if (image == null) {
            throw new InformationNotFoundException("image id " + id + "not found.");
        }
        else {
            imageRepository.deleteImageById(id);
        }
    }

    @Override
    public Image getImage(Long id) {
        Image image = imageRepository.findImageById(id);

        if (image == null) {
            throw new InformationNotFoundException("Image id " + id + "not found.");
        } else {
            return image;
        }
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
