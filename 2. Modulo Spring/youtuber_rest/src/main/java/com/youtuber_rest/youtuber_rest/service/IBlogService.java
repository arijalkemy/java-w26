package com.youtuber_rest.youtuber_rest.service;

import java.util.List;
import java.util.Optional;

import com.youtuber_rest.youtuber_rest.model.BlogModel;

public interface IBlogService {
    public List<BlogModel> getAllBlog();
    public Optional<BlogModel> getBlogById(Long id);
    public Boolean addBLog(BlogModel newBlog);
}
