package org.example.blog.service;

import org.example.blog.dto.BlogDTO;
import org.example.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {
    Integer create(BlogDTO blog);
    BlogDTO findById(int id);
    List<BlogDTO> findAll();
}
