package com.ejercicio.manejodeblogs.service.interfaces;

import com.ejercicio.manejodeblogs.DTO.BlogEntryRequestDTO;
import com.ejercicio.manejodeblogs.entity.BlogEntry;

import java.util.List;

public interface IBlogService {
    public String addBlog(BlogEntry blogEntry);
    public BlogEntry getBlogById(int id);
    public List<BlogEntry> getAllBlogs();
}
