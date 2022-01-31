package com.example.spring_project.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private LocalDateTime createdAt;

    @Column
    private Long views;

    public Image() {
    }

    public Image(Long id, String title, LocalDateTime createdAt, Long views) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.views = views;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }
}
