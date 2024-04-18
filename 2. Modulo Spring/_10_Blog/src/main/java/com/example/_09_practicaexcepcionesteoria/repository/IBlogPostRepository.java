package com.example._09_practicaexcepcionesteoria.repository;

import com.example._09_practicaexcepcionesteoria.entity.BlogPost;

import java.util.List;

public interface IBlogPostRepository {
    List<BlogPost> getAll();
    BlogPost findById(int id);

    int add(BlogPost blogPost);
}
