package org.example.blog.service;

import org.example.blog.dto.BlogRequestDTO;
import org.example.blog.dto.BlogResponseDTO;

import java.util.List;

public interface IBlogService {
    int addBlog(BlogRequestDTO blog);
    BlogResponseDTO getBlog(int id);
    List<BlogResponseDTO> getAllBlog();
}
