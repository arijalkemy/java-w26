package com.w26.blog.service;

import com.w26.blog.dto.BlogRequest;
import com.w26.blog.dto.BlogResponse;
import com.w26.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    BlogResponse createBlog(BlogRequest newBlog);
    Blog getBlog(int id);
    List<Blog> getAllBlog();
}
