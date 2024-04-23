package com.example.libros.service;

import com.example.libros.dto.BlogDTO;

import java.util.List;

public interface IBlogService {

    public List<BlogDTO> obtenerBlogs();
    public BlogDTO obtenerBlog(int id);
    public void crearBlog(BlogDTO blogDTO);
}
