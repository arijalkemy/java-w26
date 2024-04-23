package com.example.libros.repository;

import com.example.libros.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {


    List<EntradaBlog> obtenerBlogs();
    Optional<EntradaBlog> obtenerBlog(int id);
    void crearBlog(EntradaBlog entradaBlog);
}
