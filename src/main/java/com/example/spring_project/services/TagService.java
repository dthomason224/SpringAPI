package com.example.spring_project.services;

import com.example.spring_project.models.Image;
import com.example.spring_project.models.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(Tag tag);
    Tag updateTag(Long id, Tag possibleTag);
    void deleteTag(Long id);
    Tag getTag(Long id);
    List<Tag> getAllTags();
}
