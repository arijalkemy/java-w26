package com.spring.blog.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class BlogEntry {

    private Integer id;
    private String title;
    private String autorName;
    private LocalDate publishDate;
    private static Integer idCounter = 0;

    public BlogEntry(String title, String autorName, LocalDate publishDate) {
        this.id = BlogEntry.idCounter++;
        this.title = title;
        this.autorName = autorName;
        this.publishDate = publishDate;
    }

}
