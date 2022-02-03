package com.example.spring_project.services.impl;

import com.example.spring_project.exceptions.InformationExistsException;
import com.example.spring_project.exceptions.InformationNotFoundException;
import com.example.spring_project.models.Tag;
import com.example.spring_project.repositories.TagRepository;
import com.example.spring_project.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private TagRepository tagRepository;

    @Autowired
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag createTag(Tag tag) {
        Tag possibleTag = tagRepository.findByName(tag.getName());

        if (possibleTag != null) {
            throw new InformationExistsException("Tag exists");
        }
        else {
            return tagRepository.save(possibleTag);
        }
    }

    @Override
    public Tag updateTag(Long id, Tag possibleTag) {
        Tag tag = tagRepository.findTagById(id);

        if (tag == null) {
            throw new InformationNotFoundException("Tag id of " + id + " does not exist");
        } else {
            tag.setName(possibleTag.getName());

            return tagRepository.save(tag);
        }
    }

    @Override
    public void deleteTag(Long id) {
        Tag tag = tagRepository.findTagById(id);

        if (tag == null) {
            throw new InformationNotFoundException("Tag id " + id + "not found.");
        }
        else {
            tagRepository.deleteTagById(id);
        }
    }

    @Override
    public Tag getTag(Long id) {
        Tag tag = tagRepository.findTagById(id);

        if (tag == null) {
            throw new InformationNotFoundException("Tag id " + id + "not found.");
        } else {
            return tag;
        }
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
