package com.example._09_practicaexcepcionesteoria.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class BlogPost {
    private int idBlog;
    private String title;
    private String author;
    private LocalDate publicationDate;

    public BlogPost(int idBlog, String title, String author, LocalDate publicationDate) {
        this.idBlog = idBlog;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }
}
