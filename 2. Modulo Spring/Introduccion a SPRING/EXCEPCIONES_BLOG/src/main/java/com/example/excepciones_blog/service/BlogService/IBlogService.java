package com.example.excepciones_blog.service.BlogService;

import com.example.excepciones_blog.dto.BlogDto;

import java.util.List;
import java.util.UUID;

public interface IBlogService {

    void createBlog(BlogDto blogDto);
    BlogDto getBlog(UUID id);
    List<BlogDto> getAllBlogs();

}
