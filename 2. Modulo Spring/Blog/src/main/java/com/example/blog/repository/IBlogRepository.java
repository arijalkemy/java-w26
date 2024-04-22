package com.example.blog.repository;

import com.example.blog.dto.BlogDTO;

import java.util.Map;

public interface IBlogRepository {
    public void saveBlog(BlogDTO blogDTO);
    public String findBlog(Integer id);
    public Map<Integer, BlogDTO> getAll();
}
