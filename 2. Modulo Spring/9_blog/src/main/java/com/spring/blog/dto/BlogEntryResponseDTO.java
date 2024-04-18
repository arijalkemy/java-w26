package com.spring.blog.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class BlogEntryResponseDTO implements Serializable {

    private Integer id;
    private String title;
    private String autorName;
    private String publishDate;

    public BlogEntryResponseDTO(Integer id, String title, String autorName, String publishDate) {
        this.id = id;
        this.title = title;
        this.autorName = autorName;
        this.publishDate = publishDate;
    }

}
