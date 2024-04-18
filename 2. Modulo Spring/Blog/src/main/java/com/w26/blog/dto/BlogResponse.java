package com.w26.blog.dto;

import com.w26.blog.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class BlogResponse implements Serializable {
    private String message;
    private Blog blog;
}
