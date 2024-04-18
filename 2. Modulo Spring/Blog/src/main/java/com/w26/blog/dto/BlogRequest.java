package com.w26.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class BlogRequest implements Serializable {
    private int id;
    private String title;
    private String authorName;

    public BlogRequest(){}
}
