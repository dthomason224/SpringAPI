package com.example.spring_project.controllers;

import com.example.spring_project.models.Tag;
import com.example.spring_project.services.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tags")
public class TagController {
    private TagServiceImpl tagService;

    @Autowired
    public void setTagService(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @PostMapping()
    public Tag createTag(Long id, @RequestBody Tag tag) {
        return tagService.createTag(id, tag);
    }

    @DeleteMapping()
    public void deleteImage(Long id) {
        tagService.deleteTag(id);
    }

    @GetMapping
    public List<Tag> getAllImages() {
        return tagService.getTags();
    }
}
