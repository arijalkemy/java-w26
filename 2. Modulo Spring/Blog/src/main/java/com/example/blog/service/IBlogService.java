package com.example.blog.service;

import com.example.blog.dto.BlogDTO;

import java.util.List;
import java.util.Map;

public interface IBlogService {
    public String newBlog(BlogDTO blogDTO);
    public String findBlog(Integer id);
    public Map<Integer,BlogDTO> getAll();
}
