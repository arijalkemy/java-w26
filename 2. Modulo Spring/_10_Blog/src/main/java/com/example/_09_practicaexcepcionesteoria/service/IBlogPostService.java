package com.example._09_practicaexcepcionesteoria.service;

import com.example._09_practicaexcepcionesteoria.dto.BlogPostDTO;

import java.util.List;

public interface IBlogPostService {
    List<BlogPostDTO> getAll();
    BlogPostDTO findById(int id);

    int add(BlogPostDTO blogPostDTO);
}
