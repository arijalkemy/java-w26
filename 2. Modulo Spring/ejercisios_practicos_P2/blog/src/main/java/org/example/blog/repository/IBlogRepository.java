package org.example.blog.repository;

import org.example.blog.dto.BlogRequestDTO;
import org.example.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    List<EntradaBlog> getBlogs();
    int saveBlog(BlogRequestDTO blog);
    boolean blogExist(BlogRequestDTO blog);
    boolean blogExist(int id);
}
