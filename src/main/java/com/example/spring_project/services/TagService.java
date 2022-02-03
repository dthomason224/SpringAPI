package com.example.spring_project.services;

import com.example.spring_project.models.Image;
import com.example.spring_project.models.Tag;

import java.util.List;

public interface TagService {
    void createTag(Tag tag);
    void deleteTag(Long id);
    List<Tag> getTags();
}
