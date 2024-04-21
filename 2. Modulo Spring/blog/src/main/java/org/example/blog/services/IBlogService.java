package org.example.blog.services;

import org.example.blog.dto.BlogDTO;

import java.util.*;

public interface IBlogService {
    public Integer addBlogPost(BlogDTO blog);
    public List<BlogDTO> findAllBlogEntries();
    public BlogDTO findById(Integer id);
}
