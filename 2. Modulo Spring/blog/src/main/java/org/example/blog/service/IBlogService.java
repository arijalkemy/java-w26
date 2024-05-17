package org.example.blog.service;

import org.example.blog.dto.BlogByIdDTO;
import org.example.blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {
    BlogByIdDTO saveBlog(BlogDTO blog);
    BlogDTO getBlogById(Long id);
    List<BlogDTO> blogsAll();
}
