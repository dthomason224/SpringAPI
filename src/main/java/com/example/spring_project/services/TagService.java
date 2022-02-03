package com.example.spring_project.services;

import com.example.spring_project.models.Image;
import com.example.spring_project.models.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(Long id, Tag tag);
    void deleteTag(Long id);
    List<Tag> getTags();
}
