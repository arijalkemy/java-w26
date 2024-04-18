package com.spring.blog.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class BlogEntryDTO implements Serializable {

    private String title;
    private String autorName;

    public BlogEntryDTO(String title, String autorName) {
        this.title = title;
        this.autorName = autorName;
    }

}
