package com.example._09_practicaexcepcionesteoria.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class BlogPostDTO {
    private int idBlog;
    private String title;
    private String author;
    private LocalDate publicationDate;

    public BlogPostDTO(int idBlog, String title, String author, LocalDate publicationDate) {
        this.idBlog = idBlog;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

}
