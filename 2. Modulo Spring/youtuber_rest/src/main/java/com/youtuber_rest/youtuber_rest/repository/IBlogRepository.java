package com.youtuber_rest.youtuber_rest.repository;

import java.util.List;

import com.youtuber_rest.youtuber_rest.model.BlogModel;

public interface IBlogRepository {
    public Boolean addBlog(BlogModel newBlog);
    public List<BlogModel> getAll();
    public BlogModel getById(Long id);
}
