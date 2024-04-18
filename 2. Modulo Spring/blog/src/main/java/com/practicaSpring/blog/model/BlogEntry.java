package com.practicaSpring.blog.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BlogEntry {
    private Long id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public BlogEntry(Long id, String title, String author, LocalDate publishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }
}
