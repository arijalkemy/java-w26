package com.youtube.blog.service;

import com.youtube.blog.dto.BlogDTO;
import com.youtube.blog.entity.EntradaBlog;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface IBlogService {
    List<BlogDTO> entradasBlog = new ArrayList<>();
    public List<BlogDTO> getTodosLosBlogs();
    public BlogDTO getBlogPorId(int id);

    public ResponseEntity<String> guardarBlog(BlogDTO entradaBlog);
}
