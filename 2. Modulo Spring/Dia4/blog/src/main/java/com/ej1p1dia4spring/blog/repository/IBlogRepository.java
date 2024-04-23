package com.ej1p1dia4spring.blog.repository;

import com.ej1p1dia4spring.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    void agregarEntradaBlog(EntradaBlog blogDTO);
    EntradaBlog obtenerEntradaBlog(int id);
    List<EntradaBlog> obtenerEntradaBlogs();
}
