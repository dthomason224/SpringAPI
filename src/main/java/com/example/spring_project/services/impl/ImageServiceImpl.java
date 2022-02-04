package com.example.spring_project.services.impl;

import com.example.spring_project.exceptions.InformationExistsException;
import com.example.spring_project.exceptions.InformationNotFoundException;
import com.example.spring_project.models.Image;
import com.example.spring_project.models.Tag;
import com.example.spring_project.models.User;
import com.example.spring_project.repositories.ImageRepository;
import com.example.spring_project.repositories.TagRepository;
import com.example.spring_project.repositories.UserRepository;
import com.example.spring_project.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private ImageRepository imageRepository;
    private TagRepository tagRepository;
    private UserRepository userRepository;

    @Autowired
    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Autowired
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Image createImage(Long id, Image image) {
        Image possibleImage = imageRepository.findImageById(id);

        if (possibleImage != null) {
            throw new InformationExistsException("Image already exists");
        } else {
            return imageRepository.save(image);
        }
    }

    @Override
    public void addTagToImage(Long id, Long tagId) {
        Image possibleImage = imageRepository.findImageById(id);
        Tag possibleTag = tagRepository.findTagById(tagId);

        if (possibleImage == null) {
            throw new InformationNotFoundException("Image id of " + id + " does not exist");
        }

        if (possibleTag == null) {
            throw new InformationNotFoundException("Tag id of " + tagId + " does not exist");
        }

        possibleImage.getImageTags().add(possibleTag);

        imageRepository.flush();
        tagRepository.flush();
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
            throw new InformationNotFoundException("image id of" + id + "not found.");
        }
        else {
            imageRepository.deleteById(id);
        }
    }

    @Override
    public Image getImage(Long id) {
        Image image = imageRepository.findImageById(id);

        if (image == null) {
            throw new InformationNotFoundException("Image id of" + id + "not found.");
        } else {
            return image;
        }
    }

    @Override
    public Image addUserToImage(Long id, Long userId) {
        Image image = imageRepository.findImageById(id);
        if (image == null) {
            throw new InformationNotFoundException("Image id of" + id + "not found.");
        }

        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new InformationNotFoundException("User id of" + id + "not found.");
        }

        image.setUser(user);

        return imageRepository.save(image);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
