package com.ejerciciorest.blog.service;

import com.ejerciciorest.blog.dto.EntradaBlogDTO;
import com.ejerciciorest.blog.entities.EntradaBlog;

import java.util.List;
import java.util.Map;

public interface IBlogService {
    public Integer agregarBlog(EntradaBlog blog);

    public EntradaBlogDTO mostrarBlogId(Integer id);

    public List<EntradaBlogDTO> mostrarBlogs();
}
