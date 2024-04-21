package com.example.I.Blog.repository;

import com.example.I.Blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    List<EntradaBlog> getEntradaBlogs();
}
