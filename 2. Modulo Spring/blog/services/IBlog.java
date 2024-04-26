package org.example.blog.services;

import org.example.blog.dto.BlogDto;

import java.util.List;

public interface IBlog {
    Integer saveBlog(BlogDto blogDto);

    BlogDto getBlogById(Integer id);

    List<BlogDto> getListBlog();
}
