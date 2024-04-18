package com.practicaSpring.blog.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BlogEntryDTO {
    private Long id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public BlogEntryDTO(Long id, String title, String author, LocalDate publishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }
}
