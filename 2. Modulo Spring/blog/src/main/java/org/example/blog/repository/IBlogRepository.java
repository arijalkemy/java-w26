package org.example.blog.repository;

import org.example.blog.model.BlogEntry;

import java.util.*;

public interface IBlogRepository {
    public Integer add(BlogEntry newBlogEntry);
    public BlogEntry findById(Integer id);
    public List<BlogEntry> findAll();
    public Boolean exist(Integer id);
}
