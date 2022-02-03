package com.example.spring_project.controllers;

import com.example.spring_project.models.Tag;
import com.example.spring_project.services.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class TagController {
    private TagServiceImpl tagService;

    @Autowired
    public void setTagService(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @PostMapping(path = "/tags/")
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @DeleteMapping(path = "/tags/{tagId}/")
    public void deleteImage(@PathVariable(value = "tagId") Long id) {
        tagService.deleteTag(id);
    }

    @PutMapping(path = "/tags/{tagId}/")
    public Tag updateTag(@PathVariable(value = "tagId") Long tagId, @RequestBody Tag possibleTag) {
        return tagService.updateTag(tagId, possibleTag);
    }

    @GetMapping(path = "/tags/{tagId}/")
    public Tag getTag(@PathVariable(value = "tagId") Long tagId) {
        return tagService.getTag(tagId);
    }

    @GetMapping("/tags/")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }
}
