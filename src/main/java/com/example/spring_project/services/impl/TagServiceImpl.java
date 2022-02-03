package com.example.spring_project.services.impl;

import com.example.spring_project.models.Tag;
import com.example.spring_project.services.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Override
    public Tag createTag(Long id, Tag tag) {
        return null;
    }

    @Override
    public void deleteTag(Long id) {

    }

    @Override
    public List<Tag> getTags() {
        return null;
    }
}
